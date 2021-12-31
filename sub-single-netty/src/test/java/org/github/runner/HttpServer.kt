package org.github.runner

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.http.HttpContentCompressor
import io.netty.handler.codec.http.HttpObjectAggregator
import io.netty.handler.codec.http.HttpServerCodec
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.DefaultThreadFactory
import org.github.module.http.HttpServerHandler
import org.github.netty.ops.eventLoopGroup

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val httpServerHandler = HttpServerHandler()

  val boss = eventLoopGroup(1, DefaultThreadFactory("http-boss"))
  val worker = eventLoopGroup(0, DefaultThreadFactory("http-worker"))

  ServerBootstrap()
    .group(boss, worker)
    .channel(NioServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(channel: Channel) {
        channel.pipeline().apply {
          addLast(loggingHandler)
          addLast(HttpServerCodec())
          addLast(HttpContentCompressor())
          addLast(HttpObjectAggregator(512 * 1024))
          addLast(httpServerHandler)
        }
      }
    })
    .bind(8000)
    .sync()
    .channel()
    .closeFuture()
    .addListener {worker.shutdownGracefully();boss.shutdownGracefully()}
}
