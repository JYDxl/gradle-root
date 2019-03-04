package org.github.netty.server

import io.netty.channel.ChannelHandlerContext
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler

class ServerSocketLoggingHandler(private val server: String): LoggingHandler(TRACE) {
  override fun channelActive(ctx: ChannelHandlerContext) {
    logger.info("[$server]  startup complete, is bound to [${ctx.channel().localAddress()}].")
    super.channelActive(ctx)
  }

  override fun channelInactive(ctx: ChannelHandlerContext) {
    logger.info("[$server] shutdown complete.")
    super.channelInactive(ctx)
  }
}
