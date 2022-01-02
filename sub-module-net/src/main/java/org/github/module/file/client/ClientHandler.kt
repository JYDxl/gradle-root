package org.github.module.file.client

import io.netty.channel.ChannelDuplexHandler
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import org.github.module.file.common.handler.ClientMsgHandler
import org.github.module.file.common.handler.InputHandler
import org.github.module.file.common.handler.MsgHandler
import org.github.ops.log
import org.springframework.stereotype.Component

@Component
@Sharable
class ClientHandler(val handlers: List<ClientMsgHandler>): ChannelDuplexHandler(), InputHandler {
  override val log = logger

  override val list: List<MsgHandler> get() = handlers

  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    @Suppress("DEPRECATION")
    super<InputHandler>.exceptionCaught(ctx, cause)
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    super<InputHandler>.channelRead(ctx, msg)
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    super<InputHandler>.channelReadComplete(ctx)
  }

  companion object {
    private val logger = ClientHandler::class.log
  }
}
