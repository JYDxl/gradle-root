package org.github.echo

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import org.github.netty.DecoderInjector
import org.github.ops.log
import java.nio.ByteOrder
import java.nio.ByteOrder.BIG_ENDIAN
import kotlin.text.Charsets.UTF_8

class LengthDecoderWithPreChecker(maxFrameLength: Int, lengthFieldOffset: Int, lengthFieldLength: Int, byteOrder: ByteOrder = BIG_ENDIAN, lengthAdjustment: Int = 0, initialBytesToStrip: Int = 0, failFast: Boolean = true): LengthFieldBasedFrameDecoder(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast), DecoderInjector {
  /** log. */
  override val log = LengthDecoderWithPreChecker::class.log

  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {
    super.decode(ctx, buf) as ByteBuf?
  }

  override fun getUnadjustedFrameLength(buf: ByteBuf, offset: Int, length: Int, order: ByteOrder): Long {
    return ByteArray(length).apply { buf.getBytes(offset, this) }.toString(UTF_8).toLong()
  }

  override fun failIfNecessary(buf: ByteBuf) {
    when(buf.readableBytes()) {
      1 -> assert(buf, 0, 1, "A")
      2 -> assert(buf, 0, 2, "AS")
    }
  }

  private fun assert(buf: ByteBuf, @Suppress("SameParameterValue") offset: Int, length: Int, expected: String) {
    val frameHeadBuf = buf.retainedSlice(offset, length)!!
    val frameHead = frameHeadBuf.toString(UTF_8).toUpperCase().also { frameHeadBuf.release() }
    if(frameHead != expected) throw FrameHeadErrorException("未知的协议帧头: $frameHead - (expected: $expected) (offset: $offset) (limit: $length)")
  }
}
