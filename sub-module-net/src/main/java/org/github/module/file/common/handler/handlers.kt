package org.github.module.file.common.handler

import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandler
import org.github.module.file.common.dto.protocol.CommonMsg
import org.github.module.file.common.dto.protocol.HeartBeat
import org.github.netty.ops.hasMark
import org.github.netty.ops.info
import org.github.netty.ops.mark
import org.github.ops.error
import org.github.ops.warn
import org.github.spring.bootstrap.AppCtxHolder.getAppCtx
import org.slf4j.Logger
import java.lang.reflect.ParameterizedType

@Suppress("UNCHECKED_CAST")
abstract class BaseHandler<T: CommonMsg<*>>: MsgHandler {
  val type = (javaClass.genericSuperclass as ParameterizedType).actualTypeArguments[0] as Class<T>

  override fun supports(msg: Any) = type.isInstance(msg)
}

interface MsgHandler {
  fun supports(msg: Any): Boolean

  abstract fun handle(ctx: ChannelHandlerContext, input: Any)
}

interface ServerMsgHandler: MsgHandler

interface ClientMsgHandler: MsgHandler

interface InputHandler: ChannelInboundHandler {
  val log: Logger

  val list: List<MsgHandler>

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    var flag = false
    for (handler in list) {
      if (handler.supports(msg)) {
        handler.handle(ctx, msg)
        flag = true
      }
    }

    val channel = ctx.channel()!!
    if (channel.hasMark) getAppCtx()?.publishEvent(HeartBeat(channel.mark))

    if (!flag) log.warn {"消息【$msg】暂不处理"}
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }

  @Deprecated("Deprecated in Java")
  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    log.error(cause) {"对象【${ctx.channel().info}】异常: ${cause.message}"}
    ctx.close()
  }
}
