package org.github.runner

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.group.DefaultChannelGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.SocketChannel
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.ImmediateEventExecutor
import org.github.module.line.LineDecoder
import org.github.module.line.LineEncoder
import org.github.module.line.LineServerHandler
import org.github.thread.NaiveThreadFactory
import kotlin.text.Charsets.UTF_8

fun main() {
  val lineGroup = DefaultChannelGroup("line-group", ImmediateEventExecutor.INSTANCE)
  val lineServerHandler = LineServerHandler(lineGroup)
  val loggingHandler = LoggingHandler(TRACE)
  val lineDecoder = StringDecoder(UTF_8)
  val lineEncoder = LineEncoder()

  val boss = NioEventLoopGroup(1, NaiveThreadFactory("line-boss"))
  val worker = NioEventLoopGroup(0, NaiveThreadFactory("line-worker"))
  val serverBootstrap = ServerBootstrap()
    .group(boss, worker)
    .channel(NioServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<SocketChannel>() {
      override fun initChannel(channel: SocketChannel) {
        channel.pipeline()!!.apply {
          addLast(loggingHandler)
          addLast(LineDecoder(1024))
          addLast(lineDecoder)
          addLast(lineEncoder)
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
