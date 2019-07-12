package org.github.module.line

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import io.netty.buffer.ByteBufUtil
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder
import java.nio.CharBuffer
import kotlin.text.Charsets.UTF_8

@Sharable
class LineEncoder: MessageToMessageEncoder<CharSequence>() {
  override fun encode(ctx: ChannelHandlerContext, msg: CharSequence, out: MutableList<Any>) {
    out.add(toByteBuf(ctx.alloc(), msg))
  }

  companion object {

    private const val delimiter = '\n'

    private fun CharSequence.toBuf(alloc: ByteBufAllocator) = ByteBufUtil.encodeString(alloc, CharBuffer.wrap(this), UTF_8)!!

    fun toByteBuf(alloc: ByteBufAllocator, msg: CharSequence): ByteBuf {
      if(msg.endsWith(delimiter)) {
        return msg.toBuf(alloc)
      }
      val data = msg.toBuf(alloc)
      val line = Unpooled.wrappedBuffer(byteArrayOf(delimiter.toByte()))
      return alloc.compositeBuffer(2)!!.also {
        it.addComponent(true, data)
        it.addComponent(true, line)
      }
    }
  }
}
