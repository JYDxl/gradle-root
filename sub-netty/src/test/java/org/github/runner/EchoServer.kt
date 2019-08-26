package org.github.runner

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.kqueue.KQueueEventLoopGroup
import io.netty.channel.kqueue.KQueueServerSocketChannel
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import org.github.module.echo.EchoDecoder
import org.github.module.echo.EchoServerHandler
import org.github.thread.NativeThreadFactory

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val echoServerHandler = EchoServerHandler()

  val boss = KQueueEventLoopGroup(1, NativeThreadFactory("echo-boss"))
  val worker = KQueueEventLoopGroup(0, NativeThreadFactory("echo-worker"))

  ServerBootstrap()
    .group(boss, worker)
    .channel(KQueueServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(channel: Channel) {
        channel.pipeline()!!.apply {
          addLast(loggingHandler)
          addLast(EchoDecoder(1024, stripDelimiter = false))
          addLast(echoServerHandler)
        }
      }
    })
    .bind(8000)
    .sync()
    .channel()
    .closeFuture()
    .addListener { worker.shutdownGracefully();boss.shutdownGracefully() }
}
