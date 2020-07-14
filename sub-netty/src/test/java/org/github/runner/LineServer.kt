package org.github.runner

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.group.DefaultChannelGroup
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.ImmediateEventExecutor.*
import org.github.module.line.LineEncoder
import org.github.module.line.LineServerHandler
import org.github.netty.decoder.DefaultLineDecoder
import org.github.thread.NativeThreadFactory
import kotlin.text.Charsets.UTF_8

fun main() {
  val lineGroup = DefaultChannelGroup("line-group", INSTANCE)
  val lineServerHandler = LineServerHandler(lineGroup)
  val loggingHandler = LoggingHandler(TRACE)
  val stringDecoder = StringDecoder(UTF_8)
  val stringEncoder = LineEncoder()

  val boss = NioEventLoopGroup(1, NativeThreadFactory("line-boss"))
  val worker = NioEventLoopGroup(0, NativeThreadFactory("line-worker"))

  ServerBootstrap()
    .group(boss, worker)
    .channel(NioServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(channel: Channel) {
        channel.pipeline().apply {
          addLast(loggingHandler)
          addLast(DefaultLineDecoder(1024))
          addLast(stringDecoder)
          addLast(stringEncoder)
          addLast(lineServerHandler)
        }
      }
    })
    .bind(8000)
    .sync()
    .channel()
    .closeFuture()
    .addListener { worker.shutdownGracefully();boss.shutdownGracefully() }
}
