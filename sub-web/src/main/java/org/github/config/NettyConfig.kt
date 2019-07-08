package org.github.config

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption.SO_BACKLOG
import io.netty.channel.ChannelOption.SO_KEEPALIVE
import io.netty.channel.ChannelOption.SO_REUSEADDR
import io.netty.channel.ChannelOption.TCP_NODELAY
import io.netty.channel.group.DefaultChannelGroup
import io.netty.channel.kqueue.KQueueEventLoopGroup
import io.netty.channel.kqueue.KQueueServerSocketChannel
import io.netty.channel.kqueue.KQueueSocketChannel
import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import io.netty.handler.codec.LineBasedFrameDecoder
import io.netty.handler.codec.string.LineEncoder
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.util.concurrent.ImmediateEventExecutor.INSTANCE
import org.github.netty.StringServerChannelHandler
import org.github.thread.NaiveThreadFactory
import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope

@Configuration
class NettyConfig(private val props: NettyProperties): InitializingBean, DisposableBean {
  override fun afterPropertiesSet() {
    val boss = KQueueEventLoopGroup(1, NaiveThreadFactory("kqueue-boss"))
    val worker = KQueueEventLoopGroup(props.size, NaiveThreadFactory("kqueue-worker"))
    ServerBootstrap()
      .group(boss, worker)
      .channel(KQueueServerSocketChannel::class.java)
      .option(SO_REUSEADDR, true)
      .option(SO_BACKLOG, 1024)
      .handler(loggingHandler())
      .childHandler(object: ChannelInitializer<KQueueSocketChannel>() {
        override fun initChannel(channel: KQueueSocketChannel) {
          channel.pipeline()!!.apply {
            addLast(loggingHandler())
            addLast(lineBasedFrameDecoder())
            addLast(stringDecoder())
            addLast(lineEncoder())
            addLast(stringServerChannelHandler())
          }
        }
      })
      .childOption(SO_KEEPALIVE, true)
      .childOption(TCP_NODELAY, true)
      .bind(props.port)
      .sync()
      .channel()
      .let { kqueueGroup().add(it) }
  }

  override fun destroy() {
    kqueueGroup().close().awaitUninterruptibly()
  }

  @Scope(SCOPE_PROTOTYPE)
  @Bean
  fun lineBasedFrameDecoder() = LineBasedFrameDecoder(1024, true, true)

  @Scope(SCOPE_PROTOTYPE)
  @Bean
  fun lengthFieldBasedFrameDecoder() = LengthFieldBasedFrameDecoder(1024, 4, 4)

  @Bean
  fun stringDecoder() = StringDecoder()

  @Bean
  fun lineEncoder() = LineEncoder()

  @Bean
  fun loggingHandler() = LoggingHandler(TRACE)

  @Bean
  fun kqueueGroup() = DefaultChannelGroup("group-kqueue", INSTANCE)

  @Bean
  fun stringServerChannelHandler() = StringServerChannelHandler(kqueueGroup())
}
