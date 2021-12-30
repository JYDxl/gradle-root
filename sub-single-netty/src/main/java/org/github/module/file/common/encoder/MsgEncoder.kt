package org.github.module.file.common.encoder

import io.netty.buffer.ByteBufUtil.hexDump
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder
import org.github.module.file.common.dto.Msg
import org.github.netty.ops.info
import org.github.ops.info
import org.github.ops.log

@Sharable
class MsgEncoder: MessageToMessageEncoder<Msg>() {
  private val log = MsgEncoder::class.log

  override fun encode(ctx: ChannelHandlerContext, msg: Msg, out: MutableList<Any>) {
    out.add(msg.toByteBuf(ctx.alloc(), ctx.channel()).apply {msg.hex = hexDump(this).uppercase()})
    log.info {"向设备【${ctx.channel().info}】发送了数据: ${msg.desc()}"}
  }
}
