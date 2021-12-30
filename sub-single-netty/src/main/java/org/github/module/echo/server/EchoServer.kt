package org.github.module.echo.server

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.DefaultThreadFactory
import org.github.module.echo.server.handler.EchoServerHandler
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.serverSocketChannel
import org.github.ops.info
import org.slf4j.LoggerFactory.getLogger

fun main() {
  val boss = eventLoopGroup(1, DefaultThreadFactory("echo-boss"))
  val worker = eventLoopGroup(0, DefaultThreadFactory("echo-worker"))
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
    .addListener {boss.shutdownGracefully();worker.shutdownGracefully()}
  log.info {"这里为什么不会终止程序？之前好像知道现在又忘了..."}
}

private val log = getLogger("main")
