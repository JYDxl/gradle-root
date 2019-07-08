package org.github.runner

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import org.github.module.echo.EchoDecoder
import org.github.module.echo.EchoServerHandler
import org.github.thread.NaiveThreadFactory

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val echoServerHandler = EchoServerHandler()

  val boss = NioEventLoopGroup(1, NaiveThreadFactory("echo-boss"))
  val worker = NioEventLoopGroup(0, NaiveThreadFactory("echo-worker"))
  val serverBootstrap = ServerBootstrap()
    .group(boss, worker)
    .channel(NioServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<SocketChannel>() {
      override fun initChannel(channel: SocketChannel) {
        channel.pipeline()!!.apply {
          addLast(loggingHandler)
          addLast(EchoDecoder(1024, false))
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
