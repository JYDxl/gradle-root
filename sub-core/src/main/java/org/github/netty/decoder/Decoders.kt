package org.github.netty.decoder

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.DelimiterBasedFrameDecoder
import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import io.netty.handler.codec.LineBasedFrameDecoder
import org.github.ops.log
import org.slf4j.Logger
import java.nio.ByteOrder
import java.nio.ByteOrder.*

abstract class DelimiterDecoder(maxFrameLength: Int, delimiters: Array<ByteBuf>, stripDelimiter: Boolean = true, failFast: Boolean = true): DelimiterBasedFrameDecoder(maxFrameLength, stripDelimiter, failFast, *delimiters), DecoderInjector {
  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {
    super.decode(ctx, buf) as ByteBuf?
  }
}

abstract class LengthDecoder(maxFrameLength: Int, lengthFieldOffset: Int, lengthFieldLength: Int, lengthAdjustment: Int = 0, initialBytesToStrip: Int = 0, failFast: Boolean = true, byteOrder: ByteOrder = BIG_ENDIAN): LengthFieldBasedFrameDecoder(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast), DecoderInjector {
  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {
    super.decode(ctx, buf) as ByteBuf?
  }
}

abstract class LineDecoder(maxFrameLength: Int, stripDelimiter: Boolean = true, failFast: Boolean = true): LineBasedFrameDecoder(maxFrameLength, stripDelimiter, failFast), DecoderInjector {
  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {
    super.decode(ctx, buf) as ByteBuf?
  }
}

class DefaultDelimiterDecoder(maxFrameLength: Int, delimiters: Array<ByteBuf>, stripDelimiter: Boolean = true, failFast: Boolean = true, override val log: Logger = DefaultDelimiterDecoder::class.log): DelimiterDecoder(maxFrameLength, delimiters, stripDelimiter, failFast)

class DefaultLengthDecoder(maxFrameLength: Int, lengthFieldOffset: Int, lengthFieldLength: Int, lengthAdjustment: Int = 0, initialBytesToStrip: Int = 0, failFast: Boolean = true, byteOrder: ByteOrder = BIG_ENDIAN, override val log: Logger = DefaultLengthDecoder::class.log): LengthDecoder(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast, byteOrder), DecoderInjector

class DefaultLineDecoder(maxFrameLength: Int, stripDelimiter: Boolean = true, failFast: Boolean = true, override val log: Logger = DefaultLineDecoder::class.log): LineDecoder(maxFrameLength, stripDelimiter, failFast), DecoderInjector
