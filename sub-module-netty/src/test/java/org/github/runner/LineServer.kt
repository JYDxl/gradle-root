package org.github.runner

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.group.DefaultChannelGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.DefaultThreadFactory
import io.netty.util.concurrent.ImmediateEventExecutor.INSTANCE
import org.github.module.line.LineEncoder
import org.github.module.line.LineServerHandler
import org.github.netty.decoder.LineDecoder
import org.github.netty.ops.eventLoopGroup
import kotlin.text.Charsets.UTF_8

fun main() {
  val lineGroup = DefaultChannelGroup("line-group", INSTANCE)
  val lineServerHandler = LineServerHandler(lineGroup)
  val loggingHandler = LoggingHandler(TRACE)
  val stringDecoder = StringDecoder(UTF_8)
  val stringEncoder = LineEncoder()

  val boss = eventLoopGroup(1, DefaultThreadFactory("line-boss"))
  val worker = eventLoopGroup(0, DefaultThreadFactory("line-worker"))

  ServerBootstrap()
    .group(boss, worker)
    .channel(NioServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(channel: Channel) {
        channel.pipeline().apply {
          addLast(loggingHandler)
          addLast(LineDecoder(1024))
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
    .addListener {worker.shutdownGracefully();boss.shutdownGracefully()}
}
