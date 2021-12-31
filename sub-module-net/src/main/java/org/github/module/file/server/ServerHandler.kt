package org.github.module.file.server

import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.module.file.common.handler.InputHandler
import org.github.module.file.common.handler.MsgHandler
import org.github.module.file.common.handler.ServerMsgHandler
import org.github.ops.log
import org.springframework.stereotype.Component

@Component
@Sharable
class ServerHandler(val handlers: List<ServerMsgHandler>): ChannelInboundHandlerAdapter(), InputHandler {
  override val log = logger
  override val list: List<MsgHandler> get() = handlers

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    super<InputHandler>.channelRead(ctx, msg)
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    super<InputHandler>.channelReadComplete(ctx)
  }

  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    @Suppress("DEPRECATION")
    super<InputHandler>.exceptionCaught(ctx, cause)
  }

  companion object {
    private val logger = ServerHandler::class.log
  }
}
