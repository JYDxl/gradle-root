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
import org.github.module.line.LineDecoder
import org.github.thread.NaiveThreadFactory

fun main() {
  val cmdServerHandler = CmdServerHandler()
  val loggingHandler = LoggingHandler(TRACE)
  val cmdDecoder = CmdDecoder()

  val boss = NioEventLoopGroup(1, NaiveThreadFactory("cmd-boss"))
  val worker = NioEventLoopGroup(0, NaiveThreadFactory("cmd-worker"))
  val bootstrap = ServerBootstrap()
    .group(boss, worker)
    .channel(NioServerSocketChannel::class.java)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(channel: Channel) {
        channel.pipeline()!!.apply {
          addLast(loggingHandler)
          addLast(LineDecoder(1024))
          addLast(cmdDecoder)
          addLast(cmdServerHandler)
        }
      }
    })!!

  try {
    bootstrap.bind(8000).sync().channel().closeFuture().sync()
  } catch(e: Exception) {
    e.printStackTrace()
  } finally {
    worker.shutdownGracefully().syncUninterruptibly()
    boss.shutdownGracefully().syncUninterruptibly()
  }
}
