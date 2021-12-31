package org.github.module.file.common.codec

import io.netty.channel.ChannelHandlerContext
import org.github.module.file.common.MAX_LENGTH
import org.github.netty.decoder.LengthDecoder
import org.github.netty.ops.hasMark
import org.github.netty.ops.info
import org.github.ops.info
import org.github.ops.log
import org.github.ops.warn
import java.util.concurrent.TimeUnit.MINUTES

class FrameDecoder: LengthDecoder(1, 8, MAX_LENGTH.toInt(), getLength = {buf, _, _ -> buf.getLong(1)}, log = FrameDecoder::class.log) {
  override fun channelActive(ctx: ChannelHandlerContext) {
    val channel = ctx.channel()
    log.info {"对象【${channel.info}】上线"}
    channel.closeFuture().addListener {log.warn {"对象【${channel.info}】下线"}}
    ctx.executor().schedule({if (channel.isActive && !channel.hasMark) channel.close()}, 1, MINUTES)
    super.channelActive(ctx)
  }
}
