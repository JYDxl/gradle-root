package org.github.module.file.config

import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption.SO_REUSEADDR
import io.netty.handler.logging.LogLevel.DEBUG
import io.netty.handler.logging.LoggingHandler
import io.netty.handler.timeout.IdleStateHandler
import io.netty.util.concurrent.DefaultThreadFactory
import org.github.module.file.common.Device
import org.github.module.file.common.GlobalGroup
import org.github.module.file.common.codec.MsgCodec
import org.github.module.file.common.codec.MsgFrameDecoder
import org.github.module.file.common.handler.ServerMsgHandler
import org.github.module.file.server.ServerHandler
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.markAttr
import org.github.netty.ops.serverSocketChannel
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class ServerConfig {
  @Bean
  fun loggingHandler() = LoggingHandler(DEBUG)

  @Bean
  fun msgCodec() = MsgCodec()

  @Bean
  fun serverHandler(list: List<ServerMsgHandler>) = ServerHandler(list)

  @Bean(destroyMethod = "close")
  fun globalGroup() = GlobalGroup()

  @Bean
  fun server(loggingHandler: LoggingHandler, msgCodec: MsgCodec, serverHandler: ServerHandler, globalGroup: GlobalGroup): Channel {
    val boss = eventLoopGroup(1, DefaultThreadFactory("file-server-boss"))
    val worker = eventLoopGroup(0, DefaultThreadFactory("file-server-worker"))

    return ServerBootstrap()
      .group(boss, worker)!!
      .channel(serverSocketChannel)!!
      .handler(loggingHandler)!!
      .option(SO_REUSEADDR, true)!!
      .childHandler(object: ChannelInitializer<Channel>() {
        override fun initChannel(ch: Channel) {
          ch.pipeline()!!.apply {
            addLast(loggingHandler)
            addLast(MsgFrameDecoder())
            addLast(msgCodec)
            addLast(IdleStateHandler(60, 0, 0))
            addLast(serverHandler)
          }
        }
      })!!
      .bind(10000).sync().channel().closeFuture()!!
      .addListener {worker.shutdownGracefully(); boss.shutdownGracefully()}!!
      .channel()!!
      .apply {markAttr.getAndSet(Device("file-server", id().asShortText()));globalGroup.add(this)}
  }
}
