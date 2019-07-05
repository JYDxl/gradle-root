package org.github.module.line

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.group.ChannelGroup

@Sharable
class LineServerHandler(private val group: ChannelGroup): ChannelInboundHandlerAdapter() {
  override fun channelActive(ctx: ChannelHandlerContext) {
    group.add(ctx.channel())
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as ByteBuf
    group.writeAndFlush(msg.touch()) { it != ctx.channel() }
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }
}
