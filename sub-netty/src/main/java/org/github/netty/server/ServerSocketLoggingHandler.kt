package org.github.netty.server

import io.netty.channel.ChannelHandlerContext
import io.netty.handler.logging.LogLevel.TRACE
import io.netty.handler.logging.LoggingHandler

class ServerSocketLoggingHandler(private val serverName: String) : LoggingHandler(TRACE) {
  override fun channelActive(ctx: ChannelHandlerContext) {
    logger.debug("[$serverName]  startup complete, is bound to [${ctx.channel().localAddress()}].")
    super.channelActive(ctx)
  }

  override fun channelInactive(ctx: ChannelHandlerContext) {
    logger.debug("[$serverName] shutdown complete.")
    super.channelInactive(ctx)
  }
}
