package org.github.netty.runner

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.kqueue.KQueueServerSocketChannel
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.DefaultThreadFactory
import org.github.netty.module.echo.server.handler.EchoServerHandler
import org.github.core.netty.decoder.LineDecoder
import org.github.core.netty.ops.eventLoopGroup

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val echoServerHandler = EchoServerHandler()

  val boss = eventLoopGroup(1, DefaultThreadFactory("echo-boss"))
  val worker = eventLoopGroup(0, DefaultThreadFactory("echo-worker"))

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
