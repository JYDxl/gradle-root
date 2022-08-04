package org.github.module.file.server

import io.netty.channel.ChannelDuplexHandler
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.timeout.IdleStateEvent
import io.netty.handler.timeout.IdleStateEvent.READER_IDLE_STATE_EVENT
import org.github.module.file.common.handler.InputHandler
import org.github.module.file.common.handler.MsgHandler
import org.github.module.file.common.handler.ServerMsgHandler
import org.github.netty.ops.hasMark
import org.github.netty.ops.info
import org.github.ops.info
import org.github.ops.log
import org.github.ops.warn
import java.util.concurrent.TimeUnit.SECONDS

@Sharable
class ServerHandler(val handlers: List<ServerMsgHandler>): ChannelDuplexHandler(), InputHandler {
  override val log = logger
  override val list: List<MsgHandler> get() = handlers

  override fun channelActive(ctx: ChannelHandlerContext) {
    val channel = ctx.channel()!!
    log.info {"对象【${channel.info}】上线"}
    channel.closeFuture().addListener {log.warn {"对象【${channel.info}】下线"}}
    ctx.executor().schedule({
      if (channel.isActive && !channel.hasMark) {
        log.warn {"对象【${channel.info}】长时间未登录，断开连接"}
        channel.close()
      }
    }, 10, SECONDS)
    super.channelActive(ctx)
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    super<InputHandler>.channelRead(ctx, msg)
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    super<InputHandler>.channelReadComplete(ctx)
  }

  @Deprecated("Deprecated in Java")
  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    @Suppress("DEPRECATION")
    super<InputHandler>.exceptionCaught(ctx, cause)
  }

  override fun userEventTriggered(ctx: ChannelHandlerContext, evt: Any) {
    if (evt is IdleStateEvent) {
      if (evt === READER_IDLE_STATE_EVENT) {
        log.warn {"对象【${ctx.channel().info}】长时间未发送心跳数据，断开连接"}
        ctx.close()
      }
    }
    super.userEventTriggered(ctx, evt)
  }

  companion object {
    private val logger = ServerHandler::class.log
  }
}
