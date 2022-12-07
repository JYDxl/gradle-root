package org.github.netty.module.chat

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
    if(!msg.endsWith(org.github.netty.module.chat.delimiter)) out.add(org.github.netty.module.chat.delimiterBuf)
  }
}

internal const val delimiter = '\n'

internal val delimiterBuf = unreleasableBuffer(directBuffer(1).writeByte(org.github.netty.module.chat.delimiter.code))
