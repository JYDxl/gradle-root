package org.github.netty.module.http

import io.netty.buffer.ByteBufUtil.encodeString
import io.netty.channel.ChannelFutureListener.CLOSE
import io.netty.channel.ChannelFutureListener.FIRE_EXCEPTION_ON_FAILURE
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.handler.codec.http.DefaultFullHttpResponse
import io.netty.handler.codec.http.FullHttpRequest
import io.netty.handler.codec.http.HttpResponseStatus.OK
import java.nio.CharBuffer.wrap
import kotlin.text.Charsets.UTF_8
import org.github.core.ops.debug
import org.github.core.ops.log

@Sharable
class HttpServerHandler: SimpleChannelInboundHandler<FullHttpRequest>() {
  override fun channelRead0(ctx: ChannelHandlerContext, req: FullHttpRequest) {
    log.debug {req}
    ctx.writeAndFlush(DefaultFullHttpResponse(req.protocolVersion(), OK, encodeString(ctx.alloc(), wrap("Hello world!"), UTF_8))).addListeners(FIRE_EXCEPTION_ON_FAILURE, CLOSE)
  }

  companion object {
    /** log. */
    private val log = HttpServerHandler::class.log
  }
}
