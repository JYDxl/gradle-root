package org.github.netty

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.http.HttpObjectAggregator
import io.netty.handler.codec.http.HttpServerCodec
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.DefaultThreadFactory
import org.github.core.netty.ops.eventLoopGroup
import org.github.core.netty.ops.serverSocketChannel
import org.github.netty.module.http.HttpServerHandler

fun main() {
  val boss = eventLoopGroup(1, DefaultThreadFactory("http-boss"))
  val worker = eventLoopGroup(0, DefaultThreadFactory("http-worker"))

  val loggingHandler = LoggingHandler(TRACE)
  val httpServerHandler = HttpServerHandler()

  ServerBootstrap()
    .group(boss, worker)
    .channel(serverSocketChannel)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<SocketChannel>() {
      override fun initChannel(ch: SocketChannel) {
        ch.pipeline()!!.apply {
          addLast("LoggingHandler", loggingHandler)
          addLast("httpServerCodec", HttpServerCodec())
          addLast("httpObjectAggregator", HttpObjectAggregator(512 * 1024))
          addLast("HttpServerHandler", httpServerHandler)
        }
      }
    })
    .bind(10000)
    .sync()
    .channel()
    .closeFuture()
    .addListener {boss.shutdownGracefully();worker.shutdownGracefully()}
}
