package org.github.module.file.common.handler

import io.netty.channel.ChannelHandlerContext
import org.github.module.file.common.dto.protocol.LoginRes

class LoginResHandler: BaseHandler<LoginRes>(), ClientMsgHandler {
  override fun handle(ctx: ChannelHandlerContext, input: Any) {}
}
