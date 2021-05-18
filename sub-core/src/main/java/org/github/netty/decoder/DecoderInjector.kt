package org.github.netty.decoder

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled.EMPTY_BUFFER
import io.netty.channel.Channel
import io.netty.channel.ChannelHandlerContext
import org.github.netty.ops.info
import org.github.netty.ops.prettyHexDump
import org.github.ops.trace
import org.slf4j.Logger

interface DecoderInjector {
  val log: Logger

  val failIfNecessary: ((ByteBuf) -> Unit)?

  fun inject(ctx: ChannelHandlerContext, buf: ByteBuf, func: () -> ByteBuf?): ByteBuf? {
    val channel: Channel = ctx.channel()
    // if(!channel.isActive) return func()
    log.trace {"$channel ${channel.info} >>>>>STASH: ${buf.readableBytes()}B\n${buf.prettyHexDump}"}
    failIfNecessary?.invoke(buf)
    return func().also {
      (it ?: EMPTY_BUFFER).apply {log.trace {"$channel ${channel.info} >>PACKET>>: ${readableBytes()}B\n$prettyHexDump"}}
      log.trace {"$channel ${channel.info} REMAIN>>>>: ${buf.readableBytes()}B\n${buf.prettyHexDump}"}
    }
  }
}
