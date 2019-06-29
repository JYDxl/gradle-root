package org.github.echo

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import org.github.ops.log
import org.github.ops.prettyHexDump
import org.github.ops.trace
import java.nio.ByteOrder
import java.nio.ByteOrder.BIG_ENDIAN
import kotlin.text.Charsets.UTF_8

class LengthDecoderWithPreChecker(maxFrameLength: Int, lengthFieldOffset: Int, lengthFieldLength: Int, byteOrder: ByteOrder = BIG_ENDIAN, lengthAdjustment: Int = 0, initialBytesToStrip: Int = 0, failFast: Boolean = true): LengthFieldBasedFrameDecoder(byteOrder, maxFrameLength, lengthFieldOffset, lengthFieldLength, lengthAdjustment, initialBytesToStrip, failFast) {
  /** log. */
  private val log = LengthDecoderWithPreChecker::class.log

  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf): Any? {
    val channel = ctx.channel()!!
    if(!channel.isActive) return null
    log.trace { "$channel >>>STASH: ${buf.readableBytes()}B\n${buf.prettyHexDump}" }
    failIfNecessary(buf)
    return (super.decode(ctx, buf) as ByteBuf?).also {
      it?.apply { log.trace { "$channel >>PACK>>: ${readableBytes()}B\n$prettyHexDump" } }
      log.trace { "$channel REMAIN>>: ${buf.readableBytes()}B\n${buf.prettyHexDump}" }
    }
  }

  override fun getUnadjustedFrameLength(buf: ByteBuf, offset: Int, length: Int, order: ByteOrder): Long {
    val lengthBuf = buf.retainedSlice(offset, length)!!
    val frameLength = lengthBuf.toString(UTF_8).toLong()
    lengthBuf.release()
    return frameLength
  }

  private fun failIfNecessary(buf: ByteBuf) {
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
