package org.github.echo

import io.netty.buffer.ByteBuf
import io.netty.buffer.ByteBufUtil.prettyHexDump
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.DecoderException
import io.netty.handler.codec.LineBasedFrameDecoder
import org.github.ops.log
import org.github.ops.trace

class EchoDecoderWithPreChecker(maxLength: Int, stripDelimiter: Boolean = true, failFast: Boolean = true) : LineBasedFrameDecoder(maxLength, stripDelimiter, failFast) {
  /** log. */
  private val log = EchoDecoderWithPreChecker::class.log

  override fun decode(ctx: ChannelHandlerContext, msg: ByteBuf): Any? {
    if(!ctx.channel().isActive) return null
    log.trace { "${ctx.channel()} STASH: ${msg.readableBytes()}B\n${prettyHexDump(msg)}" }
    if(msg.readableBytes() >= 2) {
      val headBuf = msg.retainedSlice(msg.readerIndex(), 2)!!
      val head = headBuf.toString(Charsets.UTF_8)!!
      headBuf.release()
      if(!head.equals("as", ignoreCase = true)) {
        throw DecoderException("帧头[$head]错误")
      }
    }

    return super.decode(ctx, msg)
  }
}
