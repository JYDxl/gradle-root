package org.github.runner

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.kqueue.KQueueServerSocketChannel
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import org.github.module.echo.server.handler.EchoServerHandler
import org.github.netty.decoder.LineDecoder
import org.github.netty.ops.eventLoopGroup

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val echoServerHandler = EchoServerHandler()

  val boss = eventLoopGroup(1, "echo-boss")
  val worker = eventLoopGroup(0, "echo-worker")

  ServerBootstrap()
    .group(boss, worker)
    .channel(KQueueServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(channel: Channel) {
        channel.pipeline().apply {
          addLast(loggingHandler)
          addLast(LineDecoder(1024, stripDelimiter = false))
          addLast(echoServerHandler)
        }
      }
    })
    .bind(8000)
    .sync()
    .channel()
    .closeFuture()
    .addListener {worker.shutdownGracefully();boss.shutdownGracefully()}
}
