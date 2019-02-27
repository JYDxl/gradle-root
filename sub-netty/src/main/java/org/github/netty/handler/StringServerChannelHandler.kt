package org.github.netty.handler

import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.ops.log
import org.github.ops.warn

@Sharable
class StringServerChannelHandler : ChannelInboundHandlerAdapter() {
  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    log.warn { msg as String }
  }

  companion object {
    private val log = StringServerChannelHandler::class.log
  }
}
