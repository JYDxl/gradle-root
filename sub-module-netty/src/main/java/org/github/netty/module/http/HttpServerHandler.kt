package org.github.netty.module.http

import io.netty.buffer.ByteBufUtil.encodeString
import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.handler.codec.http.DefaultFullHttpResponse
import io.netty.handler.codec.http.FullHttpRequest
import io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH
import io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE
import io.netty.handler.codec.http.HttpHeaderValues.TEXT_PLAIN
import io.netty.handler.codec.http.HttpResponseStatus.OK
import io.netty.handler.codec.http.HttpUtil
import io.netty.util.concurrent.Future
import java.nio.CharBuffer.wrap
import kotlin.text.Charsets.UTF_8
import org.github.core.ops.info
import org.github.core.ops.log

@Sharable
class HttpServerHandler: SimpleChannelInboundHandler<FullHttpRequest>() {
  override fun channelRead0(ctx: ChannelHandlerContext, req: FullHttpRequest) {
    log.info {"${req.method()} ${req.uri()}"}
    val msg = encodeString(ctx.alloc(), wrap("Hello world!"), UTF_8)
    val res = DefaultFullHttpResponse(req.protocolVersion(), OK, msg)
    res.headers()[CONTENT_LENGTH] = msg.readableBytes()
    res.headers()[CONTENT_TYPE] = TEXT_PLAIN
    ctx
      .writeAndFlush(res)
      .addListener {it: Future<in Void> ->
        it as ChannelFuture
        if (!HttpUtil.isKeepAlive(req)) {
          it.channel().close()
        }
      }
  }

  companion object {
    /** log. */
    private val log = HttpServerHandler::class.log
  }
}
