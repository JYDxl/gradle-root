package org.github.module.file.common.decoder

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageDecoder
import org.github.module.file.common.dto.CMD
import kotlin.reflect.full.createInstance

@Sharable
class MsgDecoder: MessageToMessageDecoder<ByteBuf>() {
  override fun decode(ctx: ChannelHandlerContext, input: ByteBuf, out: MutableList<Any>) {
    val cmd = input.getUnsignedByte(0).toInt()
    val msg = CMD.parse(cmd).clazz.createInstance()
    msg.fill(input, ctx.channel())
    out.add(msg)
  }
}
