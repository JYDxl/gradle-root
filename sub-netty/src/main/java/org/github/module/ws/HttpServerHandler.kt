package org.github.module.ws

import io.netty.buffer.ByteBufUtil.*
import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.handler.codec.http.DefaultFullHttpResponse
import io.netty.handler.codec.http.FullHttpRequest
import io.netty.handler.codec.http.HttpHeaderNames.*
import io.netty.handler.codec.http.HttpHeaderValues.*
import io.netty.handler.codec.http.HttpResponseStatus.*
import org.github.ops.info
import org.github.ops.log
import java.nio.CharBuffer.*
import kotlin.text.Charsets.UTF_8

@Sharable
class HttpServerHandler: SimpleChannelInboundHandler<FullHttpRequest>() {
  override fun channelRead0(ctx: ChannelHandlerContext, req: FullHttpRequest) {
    val uri = req.uri()
    log.info { "${req.method()} $uri" }
    if(uri.lowercase() == "/ws") {
      ctx.fireChannelRead(req.retain())
      return
    }
    val msg = encodeString(ctx.alloc(), wrap(uri), UTF_8)
    val res = DefaultFullHttpResponse(req.protocolVersion(), OK, msg)
    res.headers()[CONTENT_LENGTH] = msg.readableBytes()
    res.headers()[CONTENT_TYPE] = TEXT_PLAIN
    ctx.writeAndFlush(res, ctx.voidPromise())
  }

  companion object {
    /** log. */
    private val log = HttpServerHandler::class.log
  }
}
