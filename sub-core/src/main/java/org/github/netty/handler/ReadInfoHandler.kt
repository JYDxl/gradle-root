package org.github.netty.handler

import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.ops.log
import java.util.function.Function

@Sharable
class ReadInfoHandler(private val func: Function<Any, String?> = turn): ChannelInboundHandlerAdapter() {
  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    readLog(log, msg, ctx.channel(), func)
    super.channelRead(ctx, msg)
  }
}

private val log = ReadInfoHandler::class.log
