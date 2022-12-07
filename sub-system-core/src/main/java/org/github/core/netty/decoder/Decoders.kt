package org.github.core.netty.decoder

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.DelimiterBasedFrameDecoder
import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import io.netty.handler.codec.LineBasedFrameDecoder
import org.github.core.ops.log
import org.slf4j.Logger
import java.nio.ByteOrder
import java.nio.ByteOrder.BIG_ENDIAN
import kotlin.Int.Companion.MAX_VALUE

open class DelimiterDecoder(delimiters: Array<ByteBuf>, maxFrameLength: Int = MAX_VALUE, stripDelimiter: Boolean = true, failFast: Boolean = true, override val failIfNecessary: ((ByteBuf) -> Unit)? = null): DelimiterBasedFrameDecoder(maxFrameLength, stripDelimiter, failFast, *delimiters), DecoderInjector {
  override val log: Logger get() = logger

  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {super.decode(ctx, buf) as ByteBuf?}

  companion object {
    private val logger = DelimiterDecoder::class.log
  }
}

open class LengthDecoder(lengthFieldOffset: Int, lengthFieldLength: Int, maxFrameLength: Int = MAX_VALUE, lengthAdjustment: Int = 0, initialBytesToStrip: Int = 0, failFast: Boolean = true, byteOrder: ByteOrder = BIG_ENDIAN, override val failIfNecessary: ((ByteBuf) -> Unit)? = null): LengthFieldBasedFrameDecoder(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast), DecoderInjector {
  override val log: Logger get() = logger

  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {super.decode(ctx, buf) as ByteBuf?}

  companion object {
    private val logger = LengthDecoder::class.log
  }
}

open class LineDecoder(maxFrameLength: Int = MAX_VALUE, stripDelimiter: Boolean = true, failFast: Boolean = true, override val failIfNecessary: ((ByteBuf) -> Unit)? = null): LineBasedFrameDecoder(maxFrameLength, stripDelimiter, failFast), DecoderInjector {
  override val log: Logger get() = logger

  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf) = inject(ctx, buf) {super.decode(ctx, buf) as ByteBuf?}

  companion object {
    private val logger = LineDecoder::class.log
  }
}
