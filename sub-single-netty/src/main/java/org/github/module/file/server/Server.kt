package org.github.module.file.server

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption.SO_REUSEADDR
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.handler.stream.ChunkedWriteHandler
import io.netty.util.concurrent.DefaultThreadFactory
import org.github.module.file.common.decoder.FrameDecoder
import org.github.module.file.common.decoder.MsgDecoder
import org.github.module.file.common.encoder.MsgEncoder
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.serverSocketChannel

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val msgDecoder = MsgDecoder()
  val msgEncoder = MsgEncoder()

  val boss = eventLoopGroup(1, DefaultThreadFactory("file-server-boss"))
  val worker = eventLoopGroup(0, DefaultThreadFactory("file-server-worker"))

  ServerBootstrap()
    .group(boss, worker)!!
    .channel(serverSocketChannel)!!
    .handler(loggingHandler)!!
    .option(SO_REUSEADDR, true)!!
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(ch: Channel) {
        ch.pipeline()!!.apply {
          addLast(loggingHandler)
          addLast(FrameDecoder())
          addLast(msgDecoder)
          addLast(msgEncoder)
          addLast(ChunkedWriteHandler())
          addLast(ServerHandler())
        }
      }
    })!!
    .bind(10000).sync().channel().closeFuture()!!
    .addListener {worker.shutdownGracefully(); boss.shutdownGracefully()}
}
