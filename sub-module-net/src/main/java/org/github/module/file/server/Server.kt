package org.github.module.file.server

import com.google.common.collect.ImmutableList.of
import io.netty.bootstrap.ServerBootstrap
import io.netty.channel.Channel
import io.netty.channel.ChannelInitializer
import io.netty.channel.ChannelOption.SO_REUSEADDR
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler
import io.netty.handler.timeout.IdleStateHandler
import io.netty.util.concurrent.DefaultThreadFactory
import org.github.module.file.common.GlobalGroup
import org.github.module.file.common.codec.MsgCodec
import org.github.module.file.common.codec.MsgFrameDecoder
import org.github.module.file.common.handler.ChatReqHandler
import org.github.module.file.common.handler.FileDownloadReqHandler
import org.github.module.file.common.handler.LoginReqHandler
import org.github.netty.ops.eventLoopGroup
import org.github.netty.ops.serverSocketChannel

fun main() {
  val loggingHandler = LoggingHandler(TRACE)
  val msgCodec = MsgCodec()
  val group = GlobalGroup()
  val serverHandler = ServerHandler(handlers = of(FileDownloadReqHandler(), LoginReqHandler(group), ChatReqHandler(group)))

  val boss = eventLoopGroup(1, DefaultThreadFactory("file-server-boss"))
  val worker = eventLoopGroup(0, DefaultThreadFactory("file-server-worker"))

  ServerBootstrap()
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
    .addListener {worker.shutdownGracefully(); boss.shutdownGracefully()}
}
