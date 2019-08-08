package org.github.module.echo.shaded

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import org.github.netty.DecoderInjector
import org.github.ops.log
import java.nio.ByteOrder
import java.nio.ByteOrder.*
import kotlin.text.Charsets.UTF_8

class LengthDecoderWithPreChecker(maxFrameLength: Int, lengthFieldOffset: Int, lengthFieldLength: Int, byteOrder: ByteOrder = BIG_ENDIAN, lengthAdjustment: Int = 0, initialBytesToStrip: Int = 0, failFast: Boolean = true): LengthFieldBasedFrameDecoder(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast), DecoderInjector {
  override val logger = log

  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {
    super.decode(ctx, buf) as ByteBuf?
  }

  override fun getUnadjustedFrameLength(buf: ByteBuf, offset: Int, length: Int, order: ByteOrder): Long {
    return ByteArray(length).apply { buf.getBytes(offset, this) }.toString(UTF_8).toLong()
  }

  companion object {
    /** log. */
    private val log = LengthDecoderWithPreChecker::class.log
  }
}
