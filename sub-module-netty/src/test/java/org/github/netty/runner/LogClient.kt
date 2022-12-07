package org.github.netty.runner

import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.nio.NioDatagramChannel
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.DefaultThreadFactory
import org.github.netty.module.log.LogClientHandler
import org.github.netty.module.log.LogEventDecoder
import org.github.core.netty.ops.eventLoopGroup

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val logEventDecoder = LogEventDecoder()
  val logClientHandler = LogClientHandler()

  val group = eventLoopGroup(0, DefaultThreadFactory("log-client"))

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
