package org.github.module.echo.server

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.handler.logging.LogLevel.*
import io.netty.handler.logging.LoggingHandler
import org.github.module.echo.server.handler.EchoServerHandler
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.serverSocketChannel
import org.github.ops.info
import org.github.ops.log

fun main() {
  val boss = eventLoopGroup(1, "echo-boss")
  val worker = eventLoopGroup(0, "echo-worker")
  val loggingHandler = LoggingHandler(TRACE)
  val echoServerHandler = EchoServerHandler()
  ServerBootstrap()
    .group(boss, worker)
    .channel(serverSocketChannel)
    .handler(loggingHandler)
    .childHandler(object: ChannelInitializer<Channel>() {
      override fun initChannel(ch: Channel) {
        ch.pipeline().apply {
          addLast(loggingHandler)
          addLast(echoServerHandler)
        }
      }
    })
    .bind(10000)
    .sync()
    .channel()
    .closeFuture()
    .addListener { boss.shutdownGracefully();worker.shutdownGracefully() }
  log.info { "这里为什么不会终止程序？之前好像知道现在又忘了..." } //TODO
}

private val log = "main".log
