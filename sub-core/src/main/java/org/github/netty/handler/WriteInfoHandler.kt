package org.github.netty.handler

import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelOutboundHandlerAdapter
import io.netty.channel.ChannelPromise
import org.github.ops.log

@Sharable
class WriteInfoHandler: ChannelOutboundHandlerAdapter() {
  override fun write(ctx: ChannelHandlerContext, msg: Any, promise: ChannelPromise) {
    writeLog(log, msg, ctx.channel())
    super.write(ctx, msg, promise)
  }
}

private val log = WriteInfoHandler::class.log
