package org.github.netty

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.group.DefaultChannelGroup
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.DefaultThreadFactory
import io.netty.util.concurrent.Future
import io.netty.util.concurrent.ImmediateEventExecutor.INSTANCE
import org.github.core.netty.decoder.LineDecoder
import org.github.core.netty.ops.eventLoopGroup
import org.github.core.netty.ops.serverSocketChannel
import org.github.netty.module.chat.ChatEncoder
import org.github.netty.module.chat.ChatServerHandler

fun main() {
  val boss = eventLoopGroup(1, DefaultThreadFactory("chat-boss"))
  val worker = eventLoopGroup(0, DefaultThreadFactory("chat-worker"))

  val loggingHandler = LoggingHandler(TRACE)
  val stringDecoder = StringDecoder()
  val chatEncoder = ChatEncoder()
  val chatServerHandler = ChatServerHandler(DefaultChannelGroup(INSTANCE))

  ServerBootstrap()
    .group(boss, worker)
    .channel(serverSocketChannel)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(ch: Channel) {
        ch.pipeline().apply {
          addLast("LoggingHandler", loggingHandler)
          addLast("chatDecoder", LineDecoder(1024))
          addLast("StringDecoder", stringDecoder)
          addLast("ChatEncoder", chatEncoder)
          addLast("ChatServerHandler", chatServerHandler)
        }
      }
    })
    .bind(10000)
    .sync()
    .channel()
    .closeFuture()
    .addListener {_: Future<in Void> ->
      boss.shutdownGracefully()
      worker.shutdownGracefully()
    }
}
