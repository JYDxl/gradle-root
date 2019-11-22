package org.github

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.http.HttpObjectAggregator
import io.netty.handler.codec.http.HttpServerCodec
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.Future
import org.github.module.http.HttpServerHandler
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.serverSocketChannel
import org.github.thread.NativeThreadFactory

fun main() {
  val boss = eventLoopGroup(1, NativeThreadFactory("http-boss"))
  val worker = eventLoopGroup(0, NativeThreadFactory("http-worker"))

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
    .addListener { _: Future<in Void> ->
      boss.shutdownGracefully()
      worker.shutdownGracefully()
    }
}
