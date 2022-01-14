package org.github.module.file.client

import cn.hutool.core.io.FileUtil.exist
import com.google.common.collect.ImmutableList.of
import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption.CONNECT_TIMEOUT_MILLIS
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.handler.timeout.IdleStateHandler
import io.netty.util.concurrent.DefaultThreadFactory
import org.github.module.file.common.codec.MsgCodec
import org.github.module.file.common.codec.MsgFrameDecoder
import org.github.module.file.common.dto.protocol.FileDownloadReq
import org.github.module.file.common.dto.protocol.LoginReq
import org.github.module.file.common.dto.protocol.protobuf.FileProto
import org.github.module.file.common.dto.protocol.protobuf.FileProto.LoginReqProto
import org.github.module.file.common.handler.FileDownloadResHandler
import org.github.module.file.common.handler.LoginResHandler
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.socketChannel
import org.github.ops.info
import org.github.ops.log
import org.github.ops.warn
import java.io.RandomAccessFile
import java.lang.System.`in`
import java.util.*
import kotlin.system.exitProcess

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val msgCodec = MsgCodec()
  val clientHandler = ClientHandler(handlers = of(FileDownloadResHandler(), LoginResHandler()))

  val group = eventLoopGroup(1, DefaultThreadFactory("file-client"))

  val channel = Bootstrap()
    .group(group)!!
    .channel(socketChannel)!!
    .option(CONNECT_TIMEOUT_MILLIS, 1000)!!
    .handler(object: ChannelInitializer<Channel>() {
      override fun initChannel(ch: Channel) {
        ch.pipeline()!!.apply {
          addLast(loggingHandler)
          addLast(MsgFrameDecoder())
          addLast(msgCodec)
          addLast(IdleStateHandler(0, 30, 0))
          addLast(clientHandler)
        }
      }
    })!!
    .connect("localhost", 10000)!!
    .sync()!!
    .channel()!!

  channel.closeFuture().addListener {
    group.shutdownGracefully()
    log.warn {"客户端连接断开，终止程序"}
    exitProcess(0)
  }

  val scanner = Scanner(`in`)
  log.info {"请输入用户名："}
  val user = scanner.nextLine()!!
  channel.writeAndFlush(LoginReq().apply {body = LoginReqProto.newBuilder().setUsername(user).setPassword(user).build()}, channel.voidPromise())
  exec(scanner, channel)
  channel.close().sync()
  group.shutdownGracefully()
}

private fun exec(scanner: Scanner, channel: Channel) {
  while (scanner.hasNextLine()) {
    val cmd = scanner.nextLine()!!
    val list = cmd.split(',')
    when (list[0]) {
      "FileDownload" -> {
        val src = list[1]
        val des = list[2]
        log.info {"文件【$src】下载开始"}

        if (!exist(des)) {
          val tmp = "$des.tmp"
          if (exist(tmp)) {
            RandomAccessFile(tmp, "r").use {
              val offset = it.length()
              channel.writeAndFlush(FileDownloadReq().apply {body = FileProto.FileDownloadReqProto.newBuilder().setOffset(offset).setSrc(src).setDes(des).build()}, channel.voidPromise())
            }
          } else {
            channel.writeAndFlush(FileDownloadReq().apply {body = FileProto.FileDownloadReqProto.newBuilder().setSrc(src).setDes(des).build()}, channel.voidPromise())
          }
        } else {
          log.info {"文件【$src】已经存在"}
        }
      }
      "Chat"         -> {}
      "CreateGroup"  -> {}
      "JoinGroup"    -> {}
      "ExitGroup"    -> {}
      "GroupChat"    -> {}
      "Quit"         -> {}
      else           -> {
        log.warn {"无效命令：$cmd"}
      }
    }
  }
}

val log = "client".log
