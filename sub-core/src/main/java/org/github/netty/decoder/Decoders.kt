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

abstract class DelimiterDecoder(maxFrameLength: Int, delimiters: Array<ByteBuf>, stripDelimiter: Boolean, failFast: Boolean): DelimiterBasedFrameDecoder(maxFrameLength, stripDelimiter, failFast, *delimiters), DecoderInjector {
  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) { super.decode(ctx, buf) as ByteBuf? }
}

abstract class LengthDecoder(maxFrameLength: Int, lengthFieldOffset: Int, lengthFieldLength: Int, lengthAdjustment: Int, initialBytesToStrip: Int, failFast: Boolean, byteOrder: ByteOrder, private val getLength: ((buf: ByteBuf, offset: Int, length: Int) -> Long)?): LengthFieldBasedFrameDecoder(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast), DecoderInjector {
  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) { super.decode(ctx, buf) as ByteBuf? }

  override fun getUnadjustedFrameLength(buf: ByteBuf, offset: Int, length: Int, order: ByteOrder) = getLength?.invoke(buf, offset, length) ?: super.getUnadjustedFrameLength(buf, offset, length, order)
}

abstract class LineDecoder(maxFrameLength: Int, stripDelimiter: Boolean, failFast: Boolean): LineBasedFrameDecoder(maxFrameLength, stripDelimiter, failFast), DecoderInjector {
  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) { super.decode(ctx, buf) as ByteBuf? }
}

class DefaultDelimiterDecoder(maxFrameLength: Int, delimiters: Array<ByteBuf>, stripDelimiter: Boolean = true, failFast: Boolean = true, override val log: Logger = DefaultDelimiterDecoder::class.log, override val failIfNecessary: ((ByteBuf) -> Unit)? = null): DelimiterDecoder(maxFrameLength, delimiters, stripDelimiter, failFast)

class DefaultLengthDecoder(maxFrameLength: Int, lengthFieldOffset: Int, lengthFieldLength: Int, lengthAdjustment: Int = 0, initialBytesToStrip: Int = 0, failFast: Boolean = true, byteOrder: ByteOrder = BIG_ENDIAN, override val log: Logger = DefaultLengthDecoder::class.log, getLength: ((buf: ByteBuf, offset: Int, length: Int) -> Long)? = null, override val failIfNecessary: ((ByteBuf) -> Unit)? = null): LengthDecoder(maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast, byteOrder, getLength), DecoderInjector

class DefaultLineDecoder(maxFrameLength: Int, stripDelimiter: Boolean = true, failFast: Boolean = true, override val log: Logger = DefaultLineDecoder::class.log, override val failIfNecessary: ((ByteBuf) -> Unit)? = null): LineDecoder(maxFrameLength, stripDelimiter, failFast), DecoderInjector
