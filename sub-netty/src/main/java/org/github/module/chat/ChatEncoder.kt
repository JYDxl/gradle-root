package org.github.module.chat

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled.*
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder
import org.github.ops.ALLOC_POOLED
import org.github.ops.ALLOC_UNPOOLED
import org.github.ops.toByteBuf

@Sharable
class ChatEncoder: MessageToMessageEncoder<CharSequence>() {
  override fun encode(ctx: ChannelHandlerContext, msg: CharSequence, out: MutableList<Any>) {
    out.add(msg.toByteBuf())
    if(!msg.endsWith(delimiter)) out.add(delimiterBuf)
  }
}

internal const val delimiter = '\n'

internal val delimiterBuf = unreleasableBuffer(ALLOC_UNPOOLED.directBuffer(1).writeByte(delimiter.toInt()))!!

fun CharSequence.encode(): ByteBuf {
  val body = toByteBuf()
  if(endsWith(delimiter)) return body
  return ALLOC_POOLED.compositeDirectBuffer(2)!!.apply {
    addComponent(true, body)
    addComponent(true, delimiterBuf)
  }
}
