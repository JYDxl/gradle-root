package org.github.runner

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.group.DefaultChannelGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.http.HttpObjectAggregator
import io.netty.handler.codec.http.HttpServerCodec
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.ImmediateEventExecutor.*
import org.github.module.ws.HttpReqHandler
import org.github.module.ws.TextWsFrameHandler
import org.github.thread.NativeThreadFactory

fun main() {
  val group = DefaultChannelGroup("ws", INSTANCE)
  val loggingHandler = LoggingHandler(TRACE)
  val httpReqHandler = HttpReqHandler("/ws")
  val textWsFrameHandler = TextWsFrameHandler(group)

  val boss = NioEventLoopGroup(1, NativeThreadFactory("ws-boss"))
  val worker = NioEventLoopGroup(0, NativeThreadFactory("ws-worker"))

  ServerBootstrap()
    .group(boss, worker)
    .channel(NioServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(channel: Channel) {
        channel.pipeline()!!.apply {
          addLast(loggingHandler)
          addLast(HttpServerCodec())
          addLast(HttpObjectAggregator(512 * 1024))
          addLast(httpReqHandler)
          addLast(WebSocketServerProtocolHandler("/ws"))
          addLast(textWsFrameHandler)
        }
      }
    })
    .bind(8000)
    .sync()
    .channel()
    .closeFuture()
    .addListener { worker.shutdownGracefully();boss.shutdownGracefully() }
}
