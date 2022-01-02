package org.github.module.file.common.handler

import io.netty.channel.ChannelHandlerContext
import org.github.module.file.common.dto.protocol.HeartBeatReq
import org.springframework.stereotype.Component

@Component
class HeartBeatReqHandler: BaseHandler<HeartBeatReq>(), ServerMsgHandler {
  override fun handle(ctx: ChannelHandlerContext, input: Any) {}
}
