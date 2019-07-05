package org.github.line

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.group.DefaultChannelGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.ImmediateEventExecutor
import org.github.echo.LineDecoderWithPreChecker
import org.github.module.line.LineServerHandler
import org.github.thread.NaiveThreadFactory

fun main() {
  val lineGroup = DefaultChannelGroup("group-line", ImmediateEventExecutor.INSTANCE)
  val lineServerHandler = LineServerHandler(lineGroup)
  val loggingHandler = LoggingHandler(TRACE)

  val boss = NioEventLoopGroup(1, NaiveThreadFactory("line-boss"))
  val worker = NioEventLoopGroup(0, NaiveThreadFactory("line-worker"))
  val serverBootstrap = ServerBootstrap()
    .group(boss, worker)
    .channel(NioServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<NioSocketChannel>() {
      override fun initChannel(channel: NioSocketChannel) {
        channel.pipeline()!!.apply {
          addLast(loggingHandler)
          addLast(LineDecoderWithPreChecker(1024, false))
          addLast(lineServerHandler)
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
