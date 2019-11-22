package org.github.module.http

import io.netty.channel.ChannelFutureListener.*
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.handler.codec.http.DefaultFullHttpResponse
import io.netty.handler.codec.http.FullHttpRequest
import io.netty.handler.codec.http.HttpResponseStatus.*
import org.github.netty.ops.toByteBuf
import org.github.ops.debug
import org.github.ops.log

@Sharable
class HttpServerHandler: SimpleChannelInboundHandler<FullHttpRequest>() {
  override fun channelRead0(ctx: ChannelHandlerContext, req: FullHttpRequest) {
    log.debug { req }
    ctx.writeAndFlush(DefaultFullHttpResponse(req.protocolVersion(), OK, "Hello world!".toByteBuf())).addListeners(FIRE_EXCEPTION_ON_FAILURE, CLOSE)
  }

  companion object {
    /** log. */
    private val log = HttpServerHandler::class.log
  }
}
