package org.github.runner

import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption.SO_BROADCAST
import io.netty.channel.socket.nio.NioDatagramChannel
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import org.github.module.log.LogEventEncoder
import org.github.netty.ops.eventLoopGroup
import java.net.InetSocketAddress

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val addr = InetSocketAddress("255.255.255.255", 8000)
  val logEventEncoder = LogEventEncoder(addr)

  val group = eventLoopGroup(0, "log-server")

  Bootstrap()
    .group(group)
    .channel(NioDatagramChannel::class.java)
    .option(SO_BROADCAST, true)
    .handler(object: ChannelInitializer<Channel>() {
      override fun initChannel(channel: Channel) {
        channel.pipeline().apply {
          addLast("LoggingHandler", loggingHandler)
          addLast("LogEventEncoder", logEventEncoder)
        }
      }
    })
    .bind(0)
    .sync()
    .channel()
    .closeFuture()
    .addListener {group.shutdownGracefully()}
}
