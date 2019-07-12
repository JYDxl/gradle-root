package org.github.netty

import io.netty.buffer.ByteBuf
import io.netty.channel.Channel
import io.netty.channel.ChannelHandlerContext
import org.github.ops.mark
import org.github.ops.prettyHexDump
import org.github.ops.trace
import org.slf4j.Logger

interface DecoderInjector {
  /** log. */
  val log: Logger

  fun inject(ctx: ChannelHandlerContext, buf: ByteBuf, func: () -> ByteBuf?): ByteBuf? {
    val channel = ctx.channel()!!
    if(!channel.isActive) return null
    log.trace { "$channel ${mark(channel)} >>>STASH: ${buf.readableBytes()}B\n${buf.prettyHexDump}" }
    failIfNecessary(buf)
    return func().also {
      it?.apply { log.trace { "$channel ${mark(channel)} >>PACK>>: ${readableBytes()}B\n$prettyHexDump" } }
      log.trace { "$channel ${mark(channel)} FINAL>>>: ${buf.readableBytes()}B\n${buf.prettyHexDump}" }
    }
  }

  fun failIfNecessary(buf: ByteBuf) {}

  private fun mark(channel: Channel) = "[MARK:${(channel.mark.get() ?: channel.remoteAddress())}]"
}
