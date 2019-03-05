package org.github.config

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption.SO_BACKLOG
import io.netty.channel.ChannelOption.SO_KEEPALIVE
import io.netty.channel.ChannelOption.SO_REUSEADDR
import io.netty.channel.ChannelOption.TCP_NODELAY
import io.netty.channel.epoll.EpollEventLoopGroup
import io.netty.channel.epoll.EpollServerSocketChannel
import io.netty.channel.epoll.EpollSocketChannel
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.handler.codec.LineBasedFrameDecoder
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.codec.string.StringEncoder
import io.netty.handler.logging.LoggingHandler
import org.github.netty.handler.StringServerChannelHandler
import org.github.netty.server.ServerChannelHolder
import org.github.netty.server.ServerSocketLoggingHandler
import org.github.thread.NaiveThreadFactory
import org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
class NettyConfig(private val props: NettyProperties) {
  @Bean
  fun epollServerChannelHolder(): ServerChannelHolder {
    val worker = EpollEventLoopGroup(props.size, NaiveThreadFactory("epoll-worker"))
    val boss = EpollEventLoopGroup(1, NaiveThreadFactory("epoll-boss"))
    return ServerBootstrap()
      .group(boss, worker)
      .channel(EpollServerSocketChannel::class.java)
      .option(SO_REUSEADDR, true)
      .option(SO_BACKLOG, 1024)
      .handler(ServerSocketLoggingHandler(props.epollServer))
      .childHandler(object: ChannelInitializer<EpollSocketChannel>() {
        override fun initChannel(channel: EpollSocketChannel) {
          channel.pipeline()!!.apply {
            addLast(loggingHandler())
            addLast(lineBasedFrameDecoder())
            addLast(stringDecoder())
            addLast(stringEncoder())
            addLast(stringServerChannelHandler())
          }
        }
      })
      .childOption(SO_KEEPALIVE, true)
      .childOption(TCP_NODELAY, true)
      .bind(props.epollPort)
      .sync()
      .channel()
      .closeFuture()
      .addListener { boss.shutdownGracefully(); worker.shutdownGracefully() }
      .let { ServerChannelHolder(it.channel()) }
  }

  @Bean
  fun nioServerChannelHolder(): ServerChannelHolder {
    val worker = NioEventLoopGroup(props.size, NaiveThreadFactory("nio-worker"))
    val boss = NioEventLoopGroup(1, NaiveThreadFactory("nio-boss"))
    return ServerBootstrap()
      .group(boss, worker)
      .channel(NioServerSocketChannel::class.java)
      .option(SO_REUSEADDR, true)
      .option(SO_BACKLOG, 1024)
      .handler(ServerSocketLoggingHandler(props.nioServer))
      .childHandler(object: ChannelInitializer<NioSocketChannel>() {
        override fun initChannel(channel: NioSocketChannel) {
          channel.pipeline()!!.apply {
            addLast(loggingHandler())
            addLast(lineBasedFrameDecoder())
            addLast(stringDecoder())
            addLast(stringEncoder())
            addLast(stringServerChannelHandler())
          }
        }
      })
      .childOption(SO_KEEPALIVE, true)
      .childOption(TCP_NODELAY, true)
      .bind(props.nioPort)
      .sync()
      .channel()
      .closeFuture()
      .addListener { boss.shutdownGracefully(); worker.shutdownGracefully() }
      .let { ServerChannelHolder(it.channel()) }
  }

  @Scope(SCOPE_PROTOTYPE)
  @Bean
  fun lineBasedFrameDecoder() = LineBasedFrameDecoder(1024)

  @Bean
  fun stringDecoder() = StringDecoder()

  @Bean
  fun stringEncoder() = StringEncoder()

  @Bean
  fun loggingHandler() = LoggingHandler()

  @Bean
  fun stringServerChannelHandler() = StringServerChannelHandler()
}
