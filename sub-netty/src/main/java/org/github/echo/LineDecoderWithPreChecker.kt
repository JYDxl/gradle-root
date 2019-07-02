package org.github.echo

import io.netty.buffer.ByteBuf
import io.netty.channel.Channel
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.LineBasedFrameDecoder
import org.github.ops.log
import org.github.ops.mark
import org.github.ops.prettyHexDump
import org.github.ops.trace

class LineDecoderWithPreChecker(maxLength: Int, stripDelimiter: Boolean = true, failFast: Boolean = true): LineBasedFrameDecoder(maxLength, stripDelimiter, failFast) {
  /** log. */
  private val log = LineDecoderWithPreChecker::class.log

  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf): Any? {
    val channel = ctx.channel()!!
    if(!channel.isActive) return null
    log.trace { "$channel MARK:[${mark(channel)}] >>>STASH: ${buf.readableBytes()}B\n${buf.prettyHexDump}" }
    // failIfNecessary(buf)
    return (super.decode(ctx, buf) as ByteBuf?).also {
      it?.apply { log.trace { "$channel MARK:[${mark(channel)}] >>PACK>>: ${readableBytes()}B\n$prettyHexDump" } }
      log.trace { "$channel MARK:[${mark(channel)}] REMAIN>>: ${buf.readableBytes()}B\n${buf.prettyHexDump}" }
    }
  }

  private fun mark(channel: Channel) = channel.mark.get() ?: "unknown"
}
