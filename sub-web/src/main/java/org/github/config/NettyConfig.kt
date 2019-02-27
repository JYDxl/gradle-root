package org.github.config

import io.netty.bootstrap.ServerBootstrap
import io.netty.buffer.Unpooled.copiedBuffer
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
import io.netty.handler.codec.DelimiterBasedFrameDecoder
import io.netty.handler.codec.FixedLengthFrameDecoder
import io.netty.handler.codec.LineBasedFrameDecoder
import io.netty.handler.codec.http.HttpObjectAggregator
import io.netty.handler.codec.http.HttpRequestDecoder
import io.netty.handler.codec.http.HttpResponseEncoder
import io.netty.handler.codec.protobuf.ProtobufDecoder
import io.netty.handler.codec.protobuf.ProtobufEncoder
import io.netty.handler.codec.protobuf.ProtobufVarint32FrameDecoder
import io.netty.handler.codec.protobuf.ProtobufVarint32LengthFieldPrepender
import io.netty.handler.codec.string.StringDecoder
import io.netty.handler.codec.string.StringEncoder
import io.netty.handler.logging.LoggingHandler
import io.netty.handler.stream.ChunkedWriteHandler
import org.github.netty.handler.StringServerChannelHandler
import org.github.netty.protobuf.SubscribeReqProto.SubscribeReq
import org.github.netty.server.ServerChannelHolder
import org.github.netty.server.ServerSocketLoggingHandler
import org.github.netty.socket.NaiveNioSocketChannel
import org.springframework.beans.factory.config.ConfigurableBeanFactory.SCOPE_PROTOTYPE
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.context.annotation.Scope
import kotlin.text.Charsets.UTF_8

@Configuration
class NettyConfig {
  @Bean
  fun epollServerChannelHolder(props: NettyPortProperties): ServerChannelHolder {
    val boss = EpollEventLoopGroup(1)
    val worker = EpollEventLoopGroup()
    return ServerBootstrap()
      .group(boss, worker)
      .channel(EpollServerSocketChannel::class.java)
      .option(SO_BACKLOG, 1024)
      .option(SO_REUSEADDR, true)
      .handler(ServerSocketLoggingHandler("Netty-epoll"))
      .childHandler(object: ChannelInitializer<EpollSocketChannel>() {
        override fun initChannel(channel: EpollSocketChannel) {
          channel.pipeline()!!.apply {
            addLast(loggingHandler())
            addLast(httpRequestDecoder())
            addLast(httpObjectAggregator())
            addLast(httpResponseEncoder())
            addLast(chunkedWriteHandler())
          }
        }
      })
      .childOption(SO_KEEPALIVE, true)
      .childOption(TCP_NODELAY, true)
      .bind(props.epoll)
      .sync()
      .channel()
      .closeFuture()
      .addListener { boss.shutdownGracefully();worker.shutdownGracefully() }
      .let { ServerChannelHolder(it.channel()) }
  }

  @Bean
  fun nioServerChannelHolder(props: NettyPortProperties): ServerChannelHolder {
    val boss = NioEventLoopGroup(1)
    val worker = NioEventLoopGroup()
    return ServerBootstrap()
      .group(boss, worker)
      .channel(NioServerSocketChannel::class.java)
      .option(SO_BACKLOG, 1024)
      .option(SO_REUSEADDR, true)
      .handler(ServerSocketLoggingHandler("Netty-nio"))
      .childHandler(object: ChannelInitializer<NaiveNioSocketChannel>() {
        override fun initChannel(channel: NaiveNioSocketChannel) {
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
      .bind(props.nio)
      .sync()
      .channel()
      .closeFuture()
      .addListener { boss.shutdownGracefully();worker.shutdownGracefully() }
      .let { ServerChannelHolder(it.channel()) }
  }

  @Scope(SCOPE_PROTOTYPE)
  @Bean
  fun lineBasedFrameDecoder() = LineBasedFrameDecoder(1024)

  @Scope(SCOPE_PROTOTYPE)
  @Bean
  fun delimiterBasedFrameDecoder() = DelimiterBasedFrameDecoder(1024, true, false, copiedBuffer("\$_\n", UTF_8))

  @Scope(SCOPE_PROTOTYPE)
  @Bean
  fun fixedLengthFrameDecoder() = FixedLengthFrameDecoder(20)

  @Bean
  fun stringDecoder() = StringDecoder()

  @Bean
  fun stringEncoder() = StringEncoder()

  @Bean
  fun loggingHandler() = LoggingHandler()

  @Bean
  fun stringServerChannelHandler() = StringServerChannelHandler()

  @Scope(SCOPE_PROTOTYPE)
  @Bean
  fun protobufVarint32FrameDecoder() = ProtobufVarint32FrameDecoder()

  @Bean
  fun protobufDecoder() = ProtobufDecoder(SubscribeReq.getDefaultInstance())

  @Bean
  fun protobufVarint32LengthFieldPrepender() = ProtobufVarint32LengthFieldPrepender()

  @Scope(SCOPE_PROTOTYPE)
  @Bean
  fun httpRequestDecoder() = HttpRequestDecoder()

  @Scope(SCOPE_PROTOTYPE)
  @Bean
  fun httpObjectAggregator() = HttpObjectAggregator(65536)

  @Bean
  fun protobufEncoder() = ProtobufEncoder()

  @Scope(SCOPE_PROTOTYPE)
  @Bean
  fun httpResponseEncoder() = HttpResponseEncoder()

  @Scope(SCOPE_PROTOTYPE)
  @Bean
  fun chunkedWriteHandler() = ChunkedWriteHandler()
}
