package org.github.module.file.client

import io.netty.channel.ChannelDuplexHandler
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.timeout.IdleStateEvent
import io.netty.handler.timeout.IdleStateEvent.WRITER_IDLE_STATE_EVENT
import org.github.module.file.common.dto.protocol.HeartBeatReq
import org.github.module.file.common.dto.protocol.protobuf.FileProto.HeartBeatReqProto
import org.github.module.file.common.handler.ClientMsgHandler
import org.github.module.file.common.handler.InputHandler
import org.github.module.file.common.handler.MsgHandler
import org.github.ops.log

@Sharable
class ClientHandler(val handlers: List<ClientMsgHandler>): ChannelDuplexHandler(), InputHandler {
  override val log = logger

  override val list: List<MsgHandler> get() = handlers

  @Deprecated("Deprecated in Java")
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

  override fun userEventTriggered(ctx: ChannelHandlerContext, evt: Any) {
    if (evt is IdleStateEvent) {
      if (evt === WRITER_IDLE_STATE_EVENT) {
        ctx.writeAndFlush(HeartBeatReq().apply {body = HeartBeatReqProto.getDefaultInstance()})
      }
    }
    super.userEventTriggered(ctx, evt)
  }
}
