package org.github.echo

import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.group.ChannelGroup
import io.netty.handler.codec.DecoderException
import io.netty.handler.codec.TooLongFrameException
import org.github.ops.error
import org.github.ops.info
import org.github.ops.log
import org.github.ops.mark

@Sharable
class EchoServerHandler(private val group: ChannelGroup): ChannelInboundHandlerAdapter() {
  /** log. */
  private val log = EchoServerHandler::class.log

  override fun channelActive(ctx: ChannelHandlerContext) {
    val channel = ctx.channel()!!
    channel.mark.set(channel.id().asShortText())
    group.add(channel)
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as String
    log.info { msg }
    group.writeAndFlush(msg)
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.flush()
  }

  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    if(cause is DecoderException || cause is TooLongFrameException) {
      log.error(cause) {}
      ctx.flush()
      ctx.disconnect()
      return
    }

    log.error(cause) {}
  }
}
