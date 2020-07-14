package org.github.module.echo.shaded

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.channel.group.ChannelGroup
import org.github.ops.log

@Sharable
class EchoServerHandler(private val group: ChannelGroup): SimpleChannelInboundHandler<ByteBuf>() {
  /** log. */
  private val log = EchoServerHandler::class.log

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
