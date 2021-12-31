package org.github.module.file.common.handler

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandler
import org.github.netty.ops.info
import org.github.ops.error
import org.github.ops.warn
import org.slf4j.Logger

interface InputHandler: ChannelInboundHandler {
  val log: Logger

  val list: List<MsgHandler>

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    for (handler in list) {
      if (handler.supports(msg)) {
        handler.handle(ctx, msg)
        return
      }
    }
    log.warn {"消息【$msg】暂不处理"}
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }

  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    log.error(cause) {"对象【${ctx.channel().info}】异常: ${cause.message}"}
    ctx.close()
  }
}
