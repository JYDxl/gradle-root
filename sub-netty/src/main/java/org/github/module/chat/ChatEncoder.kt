package org.github.module.chat

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import io.netty.buffer.Unpooled.*
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder
import org.github.netty.ops.toByteBuf

@Sharable
class ChatEncoder: MessageToMessageEncoder<CharSequence>() {
  override fun encode(ctx: ChannelHandlerContext, msg: CharSequence, out: MutableList<Any>) {
    out.add(msg.toByteBuf(ctx.alloc()))
    if(!msg.endsWith(delimiter)) out.add(delimiterBuf)
  }
}

internal const val delimiter = '\n'

internal val delimiterBuf = unreleasableBuffer(directBuffer(1).writeByte(delimiter.toInt()))

fun CharSequence.encode(alloc: ByteBufAllocator): ByteBuf {
  val body = toByteBuf(alloc)
  if(endsWith(delimiter)) return body
  return alloc.compositeDirectBuffer(2).apply {
    addComponent(true, body)
    addComponent(true, delimiterBuf)
  }
}
