package org.github.module.echo

import io.netty.buffer.ByteBuf
import io.netty.buffer.Unpooled
import io.netty.channel.ChannelFutureListener
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import org.github.ops.debug
import org.github.ops.error
import org.github.ops.log
import org.github.ops.putListener
import kotlin.text.Charsets.UTF_8

@Sharable
class EchoServerHandler: ChannelInboundHandlerAdapter() {
  /** log. */
  private val log = EchoServerHandler::class.log

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as ByteBuf
    log.debug { msg.toString(UTF_8) }
    ctx
      .write(msg)
      .putListener {
        if(it.isSuccess) {
          log.debug { "OK" }
        } else {
          log.error(it.cause()) {}
        }
      }
  }

  override fun channelReadComplete(ctx: ChannelHandlerContext) {
    ctx.writeAndFlush(Unpooled.EMPTY_BUFFER).addListener(ChannelFutureListener.CLOSE)
  }

  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    log.error(cause) {}
    ctx.flush()
    ctx.close()
  }
}
