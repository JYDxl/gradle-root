package org.github.netty.module.ws

import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler.HandshakeComplete
import org.github.core.netty.ops.info
import org.github.core.ops.log

@Sharable
class WsTextServerHandler: SimpleChannelInboundHandler<TextWebSocketFrame>() {
  override fun channelRead0(ctx: ChannelHandlerContext, text: TextWebSocketFrame) {
    log.error(text.text())
  }

  override fun userEventTriggered(ctx: ChannelHandlerContext, evt: Any) {
    if (evt is HandshakeComplete) {
      ctx.pipeline().remove(HttpServerHandler::class.java)
      log.warn("${ctx.channel().info}成功升级到websocket协议")
    }
  }

  companion object {
    private val log = WsTextServerHandler::class.log
  }
}
