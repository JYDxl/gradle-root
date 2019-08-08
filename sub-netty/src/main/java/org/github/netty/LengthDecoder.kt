package org.github.netty

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import org.github.ops.log
import java.nio.ByteOrder
import java.nio.ByteOrder.*

open class LengthDecoder(maxFrameLength: Int, lengthFieldOffset: Int, lengthFieldLength: Int, byteOrder: ByteOrder = BIG_ENDIAN, lengthAdjustment: Int = 0, initialBytesToStrip: Int = 0, failFast: Boolean = true): LengthFieldBasedFrameDecoder(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast), DecoderInjector {
  override val logger = log

  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {
    super.decode(ctx, buf) as ByteBuf?
  }

  companion object {
    private val log = LengthDecoder::class.log
  }
}
