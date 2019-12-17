package org.github.netty.handler

import io.netty.buffer.ByteBuf
import io.netty.channel.ChannelDuplexHandler
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelPromise
import org.github.netty.ops.hexDump
import org.github.netty.ops.info
import org.github.ops.info
import org.github.ops.log

@Sharable
class ReadWriteHexHandler: ChannelDuplexHandler() {
  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    if(msg is ByteBuf) ctx.channel().apply { log.info { "$this $info >>>>READ: ${msg.hexDump}" } }
    super.channelRead(ctx, msg)
  }

  override fun write(ctx: ChannelHandlerContext, msg: Any, promise: ChannelPromise) {
    if(msg is ByteBuf) ctx.channel().apply { log.info { "$this $info WRITE>>>: ${msg.hexDump}" } }
    super.write(ctx, msg, promise)
  }

  companion object {
    private val log = ReadWriteHexHandler::class.log
  }
}

@Sharable
class ReadHexHandler: ChannelDuplexHandler() {
  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    if(msg is ByteBuf) ctx.channel().apply { log.info { "$this $info >>>>READ: ${msg.hexDump}" } }
    super.channelRead(ctx, msg)
  }

  companion object {
    private val log = ReadHexHandler::class.log
  }
}

@Sharable
class WriteHexHandler: ChannelDuplexHandler() {
  override fun write(ctx: ChannelHandlerContext, msg: Any, promise: ChannelPromise) {
    if(msg is ByteBuf) ctx.channel().apply { log.info { "$this $info WRITE>>>: ${msg.hexDump}" } }
    super.write(ctx, msg, promise)
  }

  companion object {
    private val log = WriteHexHandler::class.log
  }
}
