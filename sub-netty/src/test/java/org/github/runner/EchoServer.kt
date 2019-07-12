package org.github.runner

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.kqueue.KQueueEventLoopGroup
import io.netty.channel.kqueue.KQueueServerSocketChannel
import io.netty.channel.socket.SocketChannel
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import org.github.module.echo.EchoDecoder
import org.github.module.echo.EchoServerHandler
import org.github.thread.NaiveThreadFactory

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val echoServerHandler = EchoServerHandler()

  val boss = KQueueEventLoopGroup(1, NaiveThreadFactory("echo-boss"))
  val worker = KQueueEventLoopGroup(0, NaiveThreadFactory("echo-worker"))
  val serverBootstrap = ServerBootstrap()
    .group(boss, worker)
    .channel(KQueueServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<SocketChannel>() {
      override fun initChannel(channel: SocketChannel) {
        channel.pipeline()!!.apply {
          addLast(loggingHandler)
          addLast(EchoDecoder(1024, stripDelimiter = false))
          addLast(echoServerHandler)
        }
      }
    })!!

  try {
    serverBootstrap.bind(8000).sync().channel().closeFuture().sync()
  } catch(e: Exception) {
    e.printStackTrace()
  } finally {
    boss.shutdownGracefully()
    worker.shutdownGracefully()
  }
}
