package org.github.module.http

import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.handler.codec.http.DefaultFullHttpResponse
import io.netty.handler.codec.http.FullHttpRequest
import io.netty.handler.codec.http.HttpHeaderNames.*
import io.netty.handler.codec.http.HttpHeaderValues.*
import io.netty.handler.codec.http.HttpResponseStatus.*
import io.netty.handler.codec.http.HttpUtil
import org.github.ops.info
import org.github.ops.log
import org.github.ops.toByteBuf

@Sharable
class HttpServerHandler: SimpleChannelInboundHandler<FullHttpRequest>() {
  override fun channelRead0(ctx: ChannelHandlerContext, req: FullHttpRequest) {
    log.info { "${req.method()} ${req.uri()}" }
    val msg = "Hello world!".toByteBuf()
    val res = DefaultFullHttpResponse(req.protocolVersion(), OK, msg).apply {
      headers().set(TRANSFER_ENCODING, CHUNKED)
    }
    ctx
      .writeAndFlush(res)
      .addListener {
        it as ChannelFuture
        if(!HttpUtil.isKeepAlive(req)) {
          it.channel().close()
        }
      }
  }

  companion object {
    /** log. */
    private val log = HttpServerHandler::class.log
  }
}
