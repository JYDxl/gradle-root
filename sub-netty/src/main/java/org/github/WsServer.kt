package org.github

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.SocketChannel
import io.netty.handler.codec.http.HttpObjectAggregator
import io.netty.handler.codec.http.HttpServerCodec
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import io.netty.handler.stream.ChunkedWriteHandler
import io.netty.util.concurrent.Future
import org.github.module.ws.HttpServerHandler
import org.github.module.ws.WsTextServerHandler
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.serverSocketChannel
import org.github.thread.NativeThreadFactory

fun main() {
  val boss = eventLoopGroup(1, NativeThreadFactory("ws-boss"))
  val worker = eventLoopGroup(0, NativeThreadFactory("ws-worker"))

  val loggingHandler = LoggingHandler(TRACE)
  val wsTextServerHandler = WsTextServerHandler()
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
          addLast("chunkedWriteHandler", ChunkedWriteHandler())
          addLast("httpObjectAggregator", HttpObjectAggregator(512 * 1024))
          addLast("HttpServerHandler", httpServerHandler)
          addLast("webSocketServerProtocolHandler", WebSocketServerProtocolHandler("/ws"))
          addLast("WsTextServerHandler", wsTextServerHandler)
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
