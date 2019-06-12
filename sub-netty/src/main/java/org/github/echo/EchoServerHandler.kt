package org.github.echo

import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.ops.info
import org.github.ops.log

@Sharable
class EchoServerHandler: ChannelInboundHandlerAdapter() {
  /** log. */
  private val log = EchoServerHandler::class.log

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as String
    log.info { msg }
    ctx.write(msg, ctx.voidPromise())
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }
}
