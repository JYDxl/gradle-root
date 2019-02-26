package org.github.netty.handler

import io.netty.channel.ChannelFutureListener.CLOSE
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.handler.codec.http.DefaultFullHttpResponse
import io.netty.handler.codec.http.FullHttpRequest
import io.netty.handler.codec.http.HttpResponseStatus.OK
import io.netty.handler.codec.http.HttpVersion.HTTP_1_1
import org.github.ops.log

@Sharable
class HttpFileServerChannelHandler: SimpleChannelInboundHandler<FullHttpRequest>() {
  override fun channelActive(ctx: ChannelHandlerContext) {
    log.info("ACTIVE")
  }

  override fun channelRead0(ctx: ChannelHandlerContext, req: FullHttpRequest) {
    log.info(req.toString())
    val resp = DefaultFullHttpResponse(HTTP_1_1, OK)
    ctx.writeAndFlush(resp).addListener(CLOSE)
  }

  override fun channelInactive(ctx: ChannelHandlerContext) {
    log.info("IN_ACTIVE")
  }

  companion object {
    /** log. */
    private val log = HttpFileServerChannelHandler::class.log
  }
}
