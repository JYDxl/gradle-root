package org.github.module.file.common.handler

import io.netty.channel.ChannelHandlerContext
import org.github.module.file.common.GlobalGroup
import org.github.module.file.common.User
import org.github.module.file.common.dto.protocol.LoginReq
import org.github.module.file.common.dto.protocol.LoginRes
import org.github.module.file.common.dto.protocol.protobuf.FileProto.LoginResProto
import org.github.netty.ops.markAttr
import org.springframework.stereotype.Component

@Component
class LoginReqHandler(val group: GlobalGroup): BaseHandler<LoginReq>(), ServerMsgHandler {
  override fun handle(ctx: ChannelHandlerContext, input: Any) {
    val msg = type.cast(input)!!
    val channel = ctx.channel()!!
    val body = msg.body
    val user = User(body.username, body.password, channel.id().asShortText())
    channel.markAttr.getAndSet(user)

    group.add(channel)

    ctx.write(LoginRes().apply {this.body = LoginResProto.newBuilder().setSuccess(true).setMessage("OK").build()}, ctx.voidPromise())
  }
}
