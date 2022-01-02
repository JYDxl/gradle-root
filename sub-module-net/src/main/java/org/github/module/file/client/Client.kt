package org.github.module.file.client

import cn.hutool.core.io.FileUtil.exist
import cn.hutool.core.io.FileUtil.getName
import com.google.common.collect.ImmutableList.of
import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.DefaultThreadFactory
import org.github.module.file.common.codec.MsgCodec
import org.github.module.file.common.codec.MsgFrameDecoder
import org.github.module.file.common.dto.protocol.FileDownloadReq
import org.github.module.file.common.dto.protocol.LoginReq
import org.github.module.file.common.dto.protocol.protobuf.FileProto.FileDownloadReqProto
import org.github.module.file.common.dto.protocol.protobuf.FileProto.LoginReqProto
import org.github.module.file.common.handler.FileDownloadResHandler
import org.github.module.file.common.handler.LoginResHandler
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.socketChannel
import org.github.ops.info
import org.github.ops.log
import java.io.RandomAccessFile
import java.lang.System.`in`
import java.util.*

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val msgCodec = MsgCodec()
  val clientHandler = ClientHandler(handlers = of(FileDownloadResHandler(), LoginResHandler()))

  val group = eventLoopGroup(1, DefaultThreadFactory("file-client"))

  val channel = Bootstrap()
    .group(group)!!
    .channel(socketChannel)!!
    .handler(object: ChannelInitializer<Channel>() {
      override fun initChannel(ch: Channel) {
        ch.pipeline()!!.apply {
          addLast(loggingHandler)
          addLast(MsgFrameDecoder())
          addLast(msgCodec)
          addLast(clientHandler)
        }
      }
    })!!
    .connect("localhost", 10000)!!
    .sync()!!
    .channel()!!

  val scanner = Scanner(`in`)
  log.info {"请输入用户名："}
  val user = scanner.next()!!
  channel.writeAndFlush(LoginReq().apply {body = LoginReqProto.newBuilder().setUsername(user).setPassword(user).build()}, channel.voidPromise())
  while (scanner.hasNext()) {
    val cmd = scanner.next()!!
    execute(cmd)
  }

  val path = "/Volumes/EXTRA/电影/教父三部曲/The.Godfather.Part.II.1974.mkv"
  log.info {"文件【$path】下载开始"}
  val name = getName(path)
  if (exist(name)) {
    RandomAccessFile(name, "r").use {
      val offset = it.length()
      channel.writeAndFlush(FileDownloadReq().apply {body = FileDownloadReqProto.newBuilder().setOffset(offset).setPath(path).build()}, channel.voidPromise())
    }
  } else {
    channel.writeAndFlush(FileDownloadReq().apply {body = FileDownloadReqProto.newBuilder().setPath(path).build()}, channel.voidPromise())
  }
  channel.closeFuture().addListener {group.shutdownGracefully()}.sync()
  log.info {"文件【$path】下载完成"}
}

fun execute(cmd: String) {
  TODO("实现$cmd")
}

val log = "client".log
