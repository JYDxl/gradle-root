package org.github.netty

import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.group.ChannelGroup
import org.github.ops.info
import org.github.ops.log

@Sharable
class StringServerChannelHandler(private val group: ChannelGroup): ChannelInboundHandlerAdapter() {
  /** log. */
  private val log = StringServerChannelHandler::class.log

  override fun channelActive(ctx: ChannelHandlerContext) {
    group.add(ctx.channel())
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    log.info { msg }
    ctx.write("$msg")
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }
}
