package org.github.echo

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.handler.codec.LineBasedFrameDecoder
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LoggingHandler
import org.github.thread.NaiveThreadFactory

fun main() {
  val echoEncoder = EchoEncoder()
  val stringDecoder = StringDecoder()
  val echoHandler = EchoServerHandler()
  val loggingHandler = LoggingHandler()

  val boss = NioEventLoopGroup(1, NaiveThreadFactory("nio-boss"))
  val worker = NioEventLoopGroup(24, NaiveThreadFactory("nio-worker"))
  val serverBootstrap = ServerBootstrap()
    .group(boss, worker)
    .channel(NioServerSocketChannel::class.java)
    .childHandler(object: ChannelInitializer<NioSocketChannel>() {
      override fun initChannel(channel: NioSocketChannel) {
        channel.pipeline()!!.apply {
          addLast(loggingHandler)
          addLast(LineBasedFrameDecoder(1024))
          addLast(stringDecoder)
          addLast(echoEncoder)
          addLast(echoHandler)
        }
      }
    })!!

  try {
    serverBootstrap
      .bind(8000)
      .sync()
      .channel()
      .closeFuture()
      .sync()
  } catch(e: Exception) {
    e.printStackTrace()
  } finally {
    boss.shutdownGracefully()
    worker.shutdownGracefully()
  }
}
