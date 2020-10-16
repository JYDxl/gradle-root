package org.github.module.echo.client

import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import org.github.module.echo.client.handler.EchoClientHandler
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.socketChannel

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val echoClientHandler = EchoClientHandler()
  val group = eventLoopGroup(1, "echo-client")
  Bootstrap()
    .group(group)
    .channel(socketChannel)
    .handler(object: ChannelInitializer<Channel>() {
      override fun initChannel(ch: Channel) {
        ch.pipeline().apply {
          addLast(loggingHandler)
          addLast(echoClientHandler)
        }
      }
    })
    .connect("mac", 10000)
    .channel()
    .closeFuture()
    .addListener { group.shutdownGracefully() }
}
