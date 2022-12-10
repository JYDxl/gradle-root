package org.github.netty.module.echo.shaded

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.channel.group.ChannelGroup

@Sharable
class EchoServerHandler(private val group: ChannelGroup): SimpleChannelInboundHandler<ByteBuf>() {
  override fun channelRead0(ctx: ChannelHandlerContext, msg: ByteBuf) {
    group.writeAndFlush(msg.retain(group.size))
  }

  override fun channelActive(ctx: ChannelHandlerContext) {
    group.add(ctx.channel())
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }
}
