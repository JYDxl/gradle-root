package org.github.module.line

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import io.netty.buffer.ByteBufUtil.*
import io.netty.buffer.Unpooled.*
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder
import io.netty.util.CharsetUtil.*
import org.github.ops.ALLOC_POOLED
import java.nio.CharBuffer.*

@Sharable
class LineEncoder: MessageToMessageEncoder<CharSequence>() {
  override fun encode(ctx: ChannelHandlerContext, msg: CharSequence, out: MutableList<Any>) {
    out.add(msg.toByteBuf())
  }

  companion object {
    private const val delimiter = '\n'

    private val line = unreleasableBuffer(buffer(1).writeByte(delimiter.toInt()))!!

    private fun CharSequence.toBuf(alloc: ByteBufAllocator) = encodeString(alloc, wrap(this), UTF_8)!!

    fun CharSequence.toByteBuf(alloc: ByteBufAllocator = ALLOC_POOLED): ByteBuf {
      val data = toBuf(alloc)
      if(endsWith(delimiter)) return data
      return alloc.compositeBuffer(2)!!.apply { addComponents(true, data, line) }
    }
  }
}
