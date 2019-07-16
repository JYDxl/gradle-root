package org.github.runner

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.http.HttpObjectAggregator
import io.netty.handler.codec.http.HttpServerCodec
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import org.github.thread.NaiveThreadFactory

fun main() {
  val loggingHandler = LoggingHandler(TRACE)

  val boss = NioEventLoopGroup(1, NaiveThreadFactory("ws-boss"))
  val worker = NioEventLoopGroup(0, NaiveThreadFactory("ws-worker"))
  val bootstrap = ServerBootstrap()
    .group(boss, worker)
    .channel(NioServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(channel: Channel) {
        channel.pipeline()!!.apply {
          addLast(loggingHandler)
          addLast(HttpServerCodec())
          addLast(HttpObjectAggregator(512 * 1024))
          addLast(WebSocketServerProtocolHandler("/ws"))
        }
      }
    })!!

  try {
    bootstrap.bind(8000).sync().channel().closeFuture().sync()
  } catch(e: Exception) {
    e.printStackTrace()
  } finally {
    worker.shutdownGracefully().syncUninterruptibly()
    boss.shutdownGracefully().syncUninterruptibly()
  }
}
