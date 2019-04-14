package org.github.netty.handler

import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.ops.info
import org.github.ops.log

@Sharable
class StringServerChannelHandler: ChannelInboundHandlerAdapter() {
  /** log. */
  private val log = StringServerChannelHandler::class.log

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    log.info { msg }
    ctx.write("$msg")
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }
}
