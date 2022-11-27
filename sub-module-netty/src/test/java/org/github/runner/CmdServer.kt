package org.github.runner

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.DefaultThreadFactory
import org.github.module.cmd.CmdDecoder
import org.github.module.cmd.CmdServerHandler
import org.github.netty.decoder.LineDecoder
import org.github.netty.ops.eventLoopGroup

fun main() {
  val cmdServerHandler = CmdServerHandler()
  val loggingHandler = LoggingHandler(TRACE)
  val cmdDecoder = CmdDecoder()

  val boss = eventLoopGroup(1, DefaultThreadFactory("cmd-boss"))
  val worker = eventLoopGroup(0, DefaultThreadFactory("cmd-worker"))

  ServerBootstrap()
    .group(boss, worker)
    .channel(NioServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(channel: Channel) {
        channel.pipeline().apply {
          addLast(loggingHandler)
          addLast(LineDecoder(1024))
          addLast(cmdDecoder)
          addLast(cmdServerHandler)
        }
      }
    })
    .bind(8000)
    .sync()
    .channel()
    .closeFuture()
    .addListener {worker.shutdownGracefully();boss.shutdownGracefully()}
}
