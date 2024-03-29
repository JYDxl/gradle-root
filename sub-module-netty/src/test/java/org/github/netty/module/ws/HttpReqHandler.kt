package org.github.netty.module.ws

import io.netty.channel.ChannelFutureListener.CLOSE
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.handler.codec.http.DefaultFullHttpResponse
import io.netty.handler.codec.http.FullHttpRequest
import io.netty.handler.codec.http.HttpHeaderNames.CONNECTION
import io.netty.handler.codec.http.HttpHeaderNames.CONTENT_LENGTH
import io.netty.handler.codec.http.HttpHeaderNames.CONTENT_TYPE
import io.netty.handler.codec.http.HttpHeaderValues.KEEP_ALIVE
import io.netty.handler.codec.http.HttpHeaderValues.TEXT_PLAIN
import io.netty.handler.codec.http.HttpResponseStatus.OK
import io.netty.handler.codec.http.HttpUtil.isKeepAlive
import io.netty.util.CharsetUtil.UTF_8
import org.github.core.ops.error
import org.github.core.ops.log

@Sharable
class HttpReqHandler(private val wsUri: String): SimpleChannelInboundHandler<FullHttpRequest>() {
  override fun channelRead0(ctx: ChannelHandlerContext, req: FullHttpRequest) {
    val uri = req.uri()
    if (uri.equals(wsUri, true)) {
      ctx.fireChannelRead(req.retain())
      return
    }
    val httpVersion = req.protocolVersion()
    val res = DefaultFullHttpResponse(httpVersion, OK)
    val msg = req.method().name() + " " + uri
    res.headers().set(CONTENT_TYPE, TEXT_PLAIN)
    res.headers().set(CONTENT_LENGTH, msg.length)
    res.content().writeCharSequence(msg, UTF_8)
    val keepAlive = isKeepAlive(req)
    if (keepAlive) res.headers().set(CONNECTION, KEEP_ALIVE)
    val future = ctx.writeAndFlush(res)
    if (!keepAlive) future.addListener(CLOSE)
  }

  @Deprecated("Deprecated in Java")
  override fun exceptionCaught(ctx: ChannelHandlerContext, cause: Throwable) {
    log.error(cause) {}
    ctx.close()
  }

  companion object {
    /** log. */
    private val log = HttpReqHandler::class.log
  }
}
