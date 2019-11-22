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
import io.netty.util.concurrent.Future
import org.github.netty.ops.toByteBuf
import org.github.ops.info
import org.github.ops.log

@Sharable
class HttpServerHandler: SimpleChannelInboundHandler<FullHttpRequest>() {
  override fun channelRead0(ctx: ChannelHandlerContext, req: FullHttpRequest) {
    log.info { "${req.method()} ${req.uri()}" }
    val msg = "Hello world!".toByteBuf()
    val res = DefaultFullHttpResponse(req.protocolVersion(), OK, msg)
    res.headers()[CONTENT_LENGTH] = msg.readableBytes()
    res.headers()[CONTENT_TYPE] = TEXT_PLAIN
    ctx
      .writeAndFlush(res)
      .addListener { it: Future<in Void> ->
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
