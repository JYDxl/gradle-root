package org.github.netty.handler

import io.netty.buffer.ByteBuf
import io.netty.channel.Channel
import io.netty.channel.ChannelDuplexHandler
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelPromise
import org.github.netty.ops.info
import org.github.ops.info
import org.github.ops.log
import org.slf4j.Logger

@Sharable
class ReadWriteInfoHandler: ChannelDuplexHandler() {
  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    readLog(log, msg, ctx.channel())
    super.channelRead(ctx, msg)
  }

  override fun write(ctx: ChannelHandlerContext, msg: Any, promise: ChannelPromise) {
    writeLog(log, msg, ctx.channel())
    super.write(ctx, msg, promise)
  }
}

private val log = ReadWriteInfoHandler::class.log

internal fun readLog(logger: Logger, msg: Any, channel: Channel) {
  if(msg !is ByteBuf) channel.apply { logger.info { "$this $info >>>>READ: $msg" } }
}

internal fun writeLog(logger: Logger, msg: Any, channel: Channel) {
  if(msg !is ByteBuf) channel.apply { logger.info { "$this $info WRITE>>>: $msg" } }
}
