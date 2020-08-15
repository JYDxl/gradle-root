package org.github.netty.decoder

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelHandlerContext
import org.github.netty.ops.info
import org.github.netty.ops.prettyHexDump
import org.github.ops.trace
import org.slf4j.Logger
import kotlin.jvm.Throws

interface DecoderInjector {
  /** log. */
  val log: Logger

  fun inject(ctx: ChannelHandlerContext, buf: ByteBuf, func: () -> ByteBuf?): ByteBuf? {
    val channel = ctx.channel()
    if(!channel.isActive) return func() //TODO 待测试
    log.trace { "$channel ${channel.info} >>>STASH: ${buf.readableBytes()}B\n${buf.prettyHexDump}" }
    failIfNecessary(buf)
    return func().also {
      it?.apply { log.trace { "$channel ${channel.info} >>PACK>>: ${readableBytes()}B\n$prettyHexDump" } }
      log.trace { "$channel ${channel.info} FINAL>>>: ${buf.readableBytes()}B\n${buf.prettyHexDump}" }
    }
  }

  @Throws(Exception::class)
  fun failIfNecessary(buf: ByteBuf) {
  }
}
