package org.github.module.log

import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import org.github.ops.debug
import org.github.ops.log

@Sharable
class LogClientHandler: SimpleChannelInboundHandler<LogEvent>() {
  override fun channelRead0(ctx: ChannelHandlerContext, msg: LogEvent) {
    log.debug { msg }
  }

  companion object {
    /** log. */
    private val log = LogClientHandler::class.log
  }
}
