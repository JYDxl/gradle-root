package org.github.netty.decoder

import io.netty.buffer.ByteBuf
import org.github.ops.log
import java.nio.ByteOrder
import java.nio.ByteOrder.*

class DefaultLengthDecoder(maxFrameLength: Int, lengthFieldOffset: Int, lengthFieldLength: Int, byteOrder: ByteOrder = BIG_ENDIAN, lengthAdjustment: Int = 0, initialBytesToStrip: Int = 0, failFast: Boolean = true): LengthDecoder(maxFrameLength, lengthFieldOffset, lengthFieldLength, byteOrder, lengthAdjustment, initialBytesToStrip, failFast), DecoderInjector {
  override val logger = log

  override fun failIfNecessary(buf: ByteBuf) {}
}

private val log = DefaultLengthDecoder::class.log
