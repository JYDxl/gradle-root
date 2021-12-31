package org.github.module.file.common.handler

import io.netty.channel.ChannelHandlerContext
import org.github.module.file.common.dto.CommonMsg
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
