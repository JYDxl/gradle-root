package org.github.module.file.common.handler

import io.netty.channel.ChannelHandlerContext
import org.github.module.file.common.GlobalGroup
import org.github.module.file.common.dto.protocol.ChatReq
import org.github.module.file.common.dto.protocol.ChatRes
import org.github.module.file.common.dto.protocol.protobuf.FileProto.ChatResProto
import org.github.netty.ops.hasMark
import org.github.netty.ops.mark
import org.springframework.stereotype.Component

@Component
class ChatReqHandler(val group: GlobalGroup): BaseHandler<ChatReq>(), ServerMsgHandler {
  override fun handle(ctx: ChannelHandlerContext, input: Any) {
    val msg = type.cast(input)!!
    val body = msg.body

    val target = group.findFirst {it.hasMark && it.mark.id == body.to}
    if (target == null) {
      ChatRes()
        .apply {
          this.body = ChatResProto
            .newBuilder()
            .setSuccess(false)
            .setMessage("对象【${body.to}】不在线")
            .build()
        }
        .run {
          ctx.write(this, ctx.voidPromise())
        }
      return
    }

    target.writeAndFlush(msg, target.voidPromise())
    ChatRes()
      .apply {
        this.body = ChatResProto
          .newBuilder()
          .setSuccess(true)
          .setMessage("OK")
          .build()
      }
      .run {
        ctx.write(this, ctx.voidPromise())
      }
  }
}
