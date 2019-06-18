package org.github.echo

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.DecoderException
import io.netty.handler.codec.LineBasedFrameDecoder

class EchoDecoderWithPreChecker(maxLength: Int, stripDelimiter: Boolean = true, failFast: Boolean = false) : LineBasedFrameDecoder(maxLength, stripDelimiter, failFast) {
  override fun decode(ctx: ChannelHandlerContext, msg: ByteBuf): Any? {
    if(!ctx.channel().isActive) return null
    if(msg.readableBytes() >= 2) {
      val headBuf = msg.retainedSlice(msg.readerIndex(), 2)!!
      val head = headBuf.toString(Charsets.UTF_8)!!
      headBuf.release()
      if(!head.equals("as", ignoreCase = true)) {
        ctx.fireExceptionCaught(DecoderException("帧头[$head]错误"))
      }
    }

    return super.decode(ctx, msg)
  }
}
