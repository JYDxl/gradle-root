package org.github.module.ws

import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.handler.codec.http.DefaultFullHttpResponse
import io.netty.handler.codec.http.FullHttpRequest
import io.netty.handler.codec.http.HttpHeaderNames.*
import io.netty.handler.codec.http.HttpHeaderValues.*
import io.netty.handler.codec.http.HttpResponseStatus.*
import io.netty.handler.codec.http.HttpUtil.*
import org.github.ops.channelFutureListener
import org.github.ops.info
import org.github.ops.log
import org.github.ops.toByteBuf

@Sharable
class HttpServerHandler: SimpleChannelInboundHandler<FullHttpRequest>() {
  override fun channelRead0(ctx: ChannelHandlerContext, req: FullHttpRequest) {
    val uri = req.uri()!!
    log.info { "${req.method()} $uri" }
    if(uri.toLowerCase() == "/ws") {
      ctx.fireChannelRead(req.retain())
      return
    }
    val msg = uri.toByteBuf()
    val res = DefaultFullHttpResponse(req.protocolVersion(), OK, msg)
    res.headers()[CONTENT_LENGTH] = msg.readableBytes()
    res.headers()[CONTENT_TYPE] = TEXT_PLAIN
    ctx.writeAndFlush(res, ctx.voidPromise())
    if(!isKeepAlive(req)) ctx.close().addListener(channelFutureListener)
  }

  companion object {
    /** log. */
    private val log = HttpServerHandler::class.log
  }
}
