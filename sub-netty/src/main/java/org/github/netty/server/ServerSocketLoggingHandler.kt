package org.github.netty.server

import io.netty.channel.ChannelHandlerContext
import io.netty.handler.logging.LoggingHandler

class ServerSocketLoggingHandler(private val serverName: String) : LoggingHandler() {
  override fun channelActive(ctx: ChannelHandlerContext) {
    logger.info("[$serverName]  startup complete, is bound to [${ctx.channel().localAddress()}].")
    super.channelActive(ctx)
  }

  override fun channelInactive(ctx: ChannelHandlerContext) {
    logger.info("[$serverName] shutdown complete.")
    super.channelInactive(ctx)
  }
}
