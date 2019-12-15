package org.github.netty.handler

import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.ops.log

@Sharable
class ReadInfoHandler: ChannelInboundHandlerAdapter() {
  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    readLog(log, msg, ctx.channel())
    super.channelRead(ctx, msg)
  }
}

private val log = ReadInfoHandler::class.log
