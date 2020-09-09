package org.github.module.chat

import io.netty.buffer.ByteBufUtil
import io.netty.buffer.Unpooled.*
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder
import java.nio.CharBuffer.*

@Sharable
class ChatEncoder: MessageToMessageEncoder<CharSequence>() {
  override fun encode(ctx: ChannelHandlerContext, msg: CharSequence, out: MutableList<Any>) {
    out.add(ByteBufUtil.encodeString(ctx.alloc(), wrap(msg), Charsets.UTF_8))
    if(!msg.endsWith(delimiter)) out.add(delimiterBuf)
  }
}

internal const val delimiter = '\n'

internal val delimiterBuf = unreleasableBuffer(directBuffer(1).writeByte(delimiter.toInt()))
