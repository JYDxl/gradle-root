package org.github.netty.decoder

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.DelimiterBasedFrameDecoder
import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import io.netty.handler.codec.LineBasedFrameDecoder
import org.github.ops.log
import org.slf4j.Logger
import java.nio.ByteOrder
import java.nio.ByteOrder.BIG_ENDIAN
import kotlin.Int.Companion.MAX_VALUE

class DelimiterDecoder(delimiters: Array<ByteBuf>, maxFrameLength: Int = MAX_VALUE, stripDelimiter: Boolean = true, failFast: Boolean = true, override val log: Logger = DelimiterDecoder::class.log, override val failIfNecessary: ((ByteBuf) -> Unit)? = null): DelimiterBasedFrameDecoder(maxFrameLength, stripDelimiter, failFast, *delimiters), DecoderInjector {
  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {super.decode(ctx, buf) as ByteBuf?}
}

class LengthDecoder(lengthFieldOffset: Int, lengthFieldLength: Int, maxFrameLength: Int = MAX_VALUE, lengthAdjustment: Int = 0, initialBytesToStrip: Int = 0, failFast: Boolean = true, byteOrder: ByteOrder = BIG_ENDIAN, override val log: Logger = LengthDecoder::class.log, private val getLength: ((buf: ByteBuf, offset: Int, length: Int) -> Long)? = null, override val failIfNecessary: ((ByteBuf) -> Unit)? = null): LengthFieldBasedFrameDecoder(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast), DecoderInjector {
  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {super.decode(ctx, buf) as ByteBuf?}

  override fun getUnadjustedFrameLength(buf: ByteBuf, offset: Int, length: Int, order: ByteOrder) = getLength?.invoke(buf, offset, length) ?: super.getUnadjustedFrameLength(buf, offset, length, order)
}

class LineDecoder(maxFrameLength: Int = MAX_VALUE, stripDelimiter: Boolean = true, failFast: Boolean = true, override val log: Logger = LineDecoder::class.log, override val failIfNecessary: ((ByteBuf) -> Unit)? = null): LineBasedFrameDecoder(maxFrameLength, stripDelimiter, failFast), DecoderInjector {
  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {super.decode(ctx, buf) as ByteBuf?}
}
