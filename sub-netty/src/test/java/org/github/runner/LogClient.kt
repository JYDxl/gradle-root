package org.github.runner

import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.nio.NioDatagramChannel
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import org.github.module.log.LogClientHandler
import org.github.module.log.LogEventDecoder
import org.github.netty.ops.eventLoopGroup

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val logEventDecoder = LogEventDecoder()
  val logClientHandler = LogClientHandler()

  val group = eventLoopGroup(0, "log-client")

  Bootstrap()
    .group(group)
    .channel(NioDatagramChannel::class.java)
    .handler(object: ChannelInitializer<Channel>() {
      override fun initChannel(channel: Channel) {
        channel.pipeline().apply {
          addLast(loggingHandler)
          addLast(logEventDecoder)
          addLast(logClientHandler)
        }
      }
    })
    .bind(8000)
    .sync()
    .channel()
    .closeFuture()
    .addListener {group.shutdownGracefully()}
}
