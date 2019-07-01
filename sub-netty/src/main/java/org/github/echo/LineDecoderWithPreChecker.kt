package org.github.echo

import io.netty.buffer.ByteBuf
import io.netty.channel.Channel
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.LineBasedFrameDecoder
import org.github.ops.ID
import org.github.ops.hasId
import org.github.ops.log
import org.github.ops.prettyHexDump
import org.github.ops.trace

class LineDecoderWithPreChecker(maxLength: Int, stripDelimiter: Boolean = true, failFast: Boolean = true): LineBasedFrameDecoder(maxLength, stripDelimiter, failFast) {
  /** log. */
  private val log = LineDecoderWithPreChecker::class.log

  override fun decode(ctx: ChannelHandlerContext, buf: ByteBuf): Any? {
    val channel = ctx.channel()!!
    if(!channel.isActive) return null
    log.trace { "$channel [ID:${getID(channel)}] >>>STASH: ${buf.readableBytes()}B\n${buf.prettyHexDump}" }
    // failIfNecessary(buf)
    return (super.decode(ctx, buf) as ByteBuf?).also {
      it?.apply { log.trace { "$channel [ID:${getID(channel)}] >>PACK>>: ${readableBytes()}B\n$prettyHexDump" } }
      log.trace { "$channel [ID:${getID(channel)}] REMAIN>>: ${buf.readableBytes()}B\n${buf.prettyHexDump}" }
    }
  }

  private fun getID(channel: Channel) = (if(channel.hasId()) channel.ID else channel.id().asShortText()).padStart(13)
}
