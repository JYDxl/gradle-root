package org.github.module.file.client

import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.DefaultThreadFactory
import org.github.module.file.common.decoder.FrameDecoder
import org.github.module.file.common.decoder.MsgDecoder
import org.github.module.file.common.dto.FileDownloadReq
import org.github.module.file.common.encoder.MsgEncoder
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.socketChannel
import org.github.ops.info
import org.github.ops.log

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val msgDecoder = MsgDecoder()
  val msgEncoder = MsgEncoder()
  val group = eventLoopGroup(1, DefaultThreadFactory("file-client"))

  val channel = Bootstrap()
    .group(group)!!
    .channel(socketChannel)!!
    .handler(object: ChannelInitializer<Channel>() {
      override fun initChannel(ch: Channel) {
        ch.pipeline()!!.apply {
          addLast(loggingHandler)
          addLast(FrameDecoder())
          addLast(msgDecoder)
          addLast(msgEncoder)
          addLast(ClientHandler())
        }
      }
    })!!
    .connect("localhost", 10000)!!
    .sync()!!
    .channel()!!
  val path = "/Volumes/EXTRA/电影/教父三部曲/The.Godfather.Part.II.1974.mkv"
  log.info {"文件【$path】下载开始"}
  channel.writeAndFlush(FileDownloadReq(path), channel.voidPromise())
  channel.closeFuture().addListener {group.shutdownGracefully()}.sync()
  log.info {"文件【$path】下载完成"}
}

val log = "main".log