package org.github.module.ssl.codec

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufAllocator
import io.netty.buffer.ByteBufUtil.*
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.MessageToMessageEncoder
import org.github.netty.ops.ALLOC_UNPOOLED
import java.nio.CharBuffer.*
import java.nio.charset.Charset
import kotlin.text.Charsets.UTF_8

@Sharable
class ServerEncoder(private val charset: Charset = UTF_8): MessageToMessageEncoder<CharSequence>() {
  override fun encode(ctx: ChannelHandlerContext, msg: CharSequence, out: MutableList<Any>) {
    out.add(msg.toByteBuf(ctx.alloc(), charset))
  }
}

private val tail = "\n".toByteArray()

fun CharSequence.toByteBuf(alloc: ByteBufAllocator = ALLOC_UNPOOLED, charset: Charset = UTF_8): ByteBuf {
  if(endsWith('\n')) return encodeString(alloc, wrap(this), charset)
  return encodeString(alloc, wrap(this), charset, tail.size).writeBytes(tail)
}
