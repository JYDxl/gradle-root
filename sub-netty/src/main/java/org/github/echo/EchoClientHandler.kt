package org.github.echo

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.ops.info
import org.github.ops.log

class EchoClientHandler: ChannelInboundHandlerAdapter() {
  /** log. */
  private val log = EchoClientHandler::class.log

  override fun channelActive(ctx: ChannelHandlerContext) {
    ctx.writeAndFlush("Netty rocks!")
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    log.info { msg as String }
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.close()
  }

  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    cause.printStackTrace()
    ctx.close()
  }
}
