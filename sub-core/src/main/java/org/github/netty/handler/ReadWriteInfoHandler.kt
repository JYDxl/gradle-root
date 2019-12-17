package org.github.netty.handler

import io.netty.buffer.ByteBuf
import io.netty.channel.Channel
import io.netty.channel.ChannelDuplexHandler
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.ChannelOutboundHandlerAdapter
import io.netty.channel.ChannelPromise
import org.github.netty.ops.info
import org.github.ops.info
import org.github.ops.log
import org.slf4j.Logger
import java.util.function.Function

@Sharable
class ReadWriteInfoHandler(private val func: Function<Any, String?> = turn): ChannelDuplexHandler() {
  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    readLog(log, msg, ctx.channel(), func)
    super.channelRead(ctx, msg)
  }

  override fun write(ctx: ChannelHandlerContext, msg: Any, promise: ChannelPromise) {
    writeLog(log, msg, ctx.channel(), func)
    super.write(ctx, msg, promise)
  }

  companion object {
    private val log = ReadWriteInfoHandler::class.log
  }
}

@Sharable
class ReadInfoHandler(private val func: Function<Any, String?> = turn): ChannelInboundHandlerAdapter() {
  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    readLog(log, msg, ctx.channel(), func)
    super.channelRead(ctx, msg)
  }

  companion object {
    private val log = ReadInfoHandler::class.log
  }
}

@Sharable
class WriteInfoHandler(private val func: Function<Any, String?> = turn): ChannelOutboundHandlerAdapter() {
  override fun write(ctx: ChannelHandlerContext, msg: Any, promise: ChannelPromise) {
    writeLog(log, msg, ctx.channel(), func)
    super.write(ctx, msg, promise)
  }

  companion object {
    private val log = WriteInfoHandler::class.log
  }
}

private val turn = Function<Any, String?> { it.toString() }

private fun readLog(logger: Logger, msg: Any, channel: Channel, func: Function<Any, String?>) {
  if(msg !is ByteBuf) channel.apply { logger.info { "$this $info >>>>READ: ${func.apply(msg)}" } }
}

private fun writeLog(logger: Logger, msg: Any, channel: Channel, func: Function<Any, String?>) {
  if(msg !is ByteBuf) channel.apply { logger.info { "$this $info WRITE>>>: ${func.apply(msg)}" } }
}
