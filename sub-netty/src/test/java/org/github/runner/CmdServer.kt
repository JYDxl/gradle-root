package org.github.runner

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import org.github.module.cmd.CmdDecoder
import org.github.module.cmd.CmdServerHandler
import org.github.netty.decoder.DefaultLineDecoder
import org.github.thread.NativeThreadFactory

fun main() {
  val cmdServerHandler = CmdServerHandler()
  val loggingHandler = LoggingHandler(TRACE)
  val cmdDecoder = CmdDecoder()

  val boss = NioEventLoopGroup(1, NativeThreadFactory("cmd-boss"))
  val worker = NioEventLoopGroup(0, NativeThreadFactory("cmd-worker"))

  ServerBootstrap()
    .group(boss, worker)
    .channel(NioServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(channel: Channel) {
        channel.pipeline().apply {
          addLast(loggingHandler)
          addLast(DefaultLineDecoder(1024))
          addLast(cmdDecoder)
          addLast(cmdServerHandler)
        }
      }
    })
    .bind(8000)
    .sync()
    .channel()
    .closeFuture()
    .addListener { worker.shutdownGracefully();boss.shutdownGracefully() }
}
