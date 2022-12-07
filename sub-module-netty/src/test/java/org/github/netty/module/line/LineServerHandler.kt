package org.github.netty.module.line

import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.group.ChannelGroup
import org.github.netty.module.line.LineEncoder.Companion.toByteBuf
import org.github.core.ops.log

@Sharable
class LineServerHandler(private val group: ChannelGroup): ChannelInboundHandlerAdapter() {
  override fun channelActive(ctx: ChannelHandlerContext) {
    group.add(ctx.channel())
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as String
    group.writeAndFlush(msg.toByteBuf(ctx.alloc()), {it != ctx.channel()}, true)
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }

  @Deprecated("Deprecated in Java")
  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
  }

  companion object {
    /** log. */
    private val log = LineServerHandler::class.log
  }
}
