package org.github

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.http.HttpObjectAggregator
import io.netty.handler.codec.http.HttpServerCodec
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import org.github.module.http.HttpServerHandler
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.ktPipeline
import org.github.netty.ops.serverSocketChannel

fun main() {
  val boss = eventLoopGroup(1, "http-boss")
  val worker = eventLoopGroup(0, "http-worker")

  val loggingHandler = LoggingHandler(TRACE)
  val httpServerHandler = HttpServerHandler()

  ServerBootstrap()
    .group(boss, worker)
    .channel(serverSocketChannel)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<SocketChannel>() {
      override fun initChannel(ch: SocketChannel) {
        ch.ktPipeline.apply {
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
