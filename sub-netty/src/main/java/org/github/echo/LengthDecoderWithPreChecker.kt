package org.github.echo

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.DecoderException
import io.netty.handler.codec.LengthFieldBasedFrameDecoder
import org.github.ops.log
import org.github.ops.prettyHexDump
import org.github.ops.trace
import java.nio.ByteOrder

class LengthDecoderWithPreChecker(byteOrder: ByteOrder = ByteOrder.BIG_ENDIAN, maxFrameLength: Int,
  lengthFieldOffset: Int, lengthFieldLength: Int, lengthAdjustment: Int = 0, initialBytesToStrip: Int = 0,
  failFast: Boolean = true) : LengthFieldBasedFrameDecoder(byteOrder, maxFrameLength, lengthFieldOffset,
                                                           lengthFieldLength, lengthAdjustment,
                                                           initialBytesToStrip, failFast) {
  /** log. */
  private val log = LengthDecoderWithPreChecker::class.log

  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf): Any? {
    if(!ctx.channel().isActive) return null
    log.trace { "${ctx.channel()} >>>STASH: ${buf.readableBytes()}B\n${buf.prettyHexDump}" }
    failIfNecessary(buf)
    return (super.decode(ctx, buf) as ByteBuf?).also {
      if(it != null) log.trace { "${ctx.channel()} >>PACK>>: ${it.readableBytes()}B\n${it.prettyHexDump}" }
      log.trace { "${ctx.channel()} REMAIN>>: ${buf.readableBytes()}B\n${buf.prettyHexDump}" }
    }
  }

  override fun getUnadjustedFrameLength(buf: ByteBuf, offset: Int, length: Int, order: ByteOrder): Long {
    val lengthBuf = buf.retainedSlice(offset, length)!!
    val frameLength = lengthBuf.toString(Charsets.UTF_8).toLong()
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
    val frameHead = frameHeadBuf.toString(Charsets.UTF_8).toUpperCase().also { frameHeadBuf.release() }
    if(frameHead != expected) throw DecoderException("未知的协议帧头: $frameHead - (expected: $expected) (offset: $offset) (limit: $length)")
  }
}
