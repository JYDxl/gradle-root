package org.github.runner

import io.netty.bootstrap.Bootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption.*
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioDatagramChannel
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import org.github.module.log.LogEvent
import org.github.module.log.LogEventEncoder
import org.github.thread.NativeThreadFactory
import java.net.InetSocketAddress
import java.util.concurrent.Executors.*
import java.util.concurrent.TimeUnit.*

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val addr = InetSocketAddress("255.255.255.255", 8000)
  val logEventEncoder = LogEventEncoder(addr)

  val group = NioEventLoopGroup(0, NativeThreadFactory("log-server"))
  val service = newScheduledThreadPool(4, NativeThreadFactory("udp-task"))

  Bootstrap()
    .group(group)
    .channel(NioDatagramChannel::class.java)
    .option(SO_BROADCAST, true)
    .handler(object: ChannelInitializer<Channel>() {
      override fun initChannel(channel: Channel) {
        channel.pipeline()!!.apply {
          addLast("LoggingHandler", loggingHandler)
          addLast("LogEventEncoder", logEventEncoder)
        }
      }
    })
    .bind(0)
    .sync()
    .channel()
    .apply { service.scheduleWithFixedDelay({ writeAndFlush(LogEvent(addr, "mac", "Hello world!")) }, 3, 1, SECONDS) }
    .closeFuture()
    .addListener { group.shutdownGracefully() }
}
