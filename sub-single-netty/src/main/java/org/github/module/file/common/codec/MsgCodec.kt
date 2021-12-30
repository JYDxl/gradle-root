package org.github.module.file.common.codec

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufUtil.hexDump
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageCodec
import org.github.module.file.common.dto.CMD.Companion.parse
import org.github.module.file.common.dto.Msg
import org.github.netty.ops.info
import org.github.ops.info
import org.github.ops.log
import kotlin.reflect.full.createInstance

@Sharable
class MsgCodec: MessageToMessageCodec<ByteBuf, Msg>() {
  private val log = MsgCodec::class.log

  override fun encode(ctx: ChannelHandlerContext, msg: Msg, out: MutableList<Any>) {
    out.add(msg.toByteBuf(ctx.alloc(), ctx.channel()).apply {msg.hex = hexDump(this).uppercase()})
    log.info {"向设备【${ctx.channel().info}】发送了数据: ${msg.desc()}"}
  }

  override fun decode(ctx: ChannelHandlerContext, input: ByteBuf, out: MutableList<Any>) {
    val cmd = input.getUnsignedByte(0).toInt()
    val msg = parse(cmd).clazz.createInstance()
    msg.fill(input, ctx.channel())
    out.add(msg)
  }
}
