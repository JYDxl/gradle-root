package org.github.netty.module.ws

import io.netty.channel.ChannelHandler.*
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.SimpleChannelInboundHandler
import io.netty.channel.group.ChannelGroup
import io.netty.channel.group.ChannelMatchers.*
import io.netty.handler.codec.http.websocketx.TextWebSocketFrame
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler.*
import org.github.core.ops.debug
import org.github.core.ops.log

@Sharable
class TextWsFrameHandler(private val group: ChannelGroup): SimpleChannelInboundHandler<TextWebSocketFrame>() {
  override fun channelRead0(ctx: ChannelHandlerContext, msg: TextWebSocketFrame) {
    log.debug { msg }
    group.writeAndFlush(msg.retain(), { it !== ctx.channel() }, true)
  }

  override fun userEventTriggered(ctx: ChannelHandlerContext, evt: Any) {
    if(evt !is HandshakeComplete) return
    ctx.pipeline().remove(HttpReqHandler::class.java)
    val channel = ctx.channel()
    group.writeAndFlush(TextWebSocketFrame("client ${channel.remoteAddress()} joined"), all(), true)
    group.add(channel)
  }

  companion object {
    /** log. */
    private val log = TextWsFrameHandler::class.log
  }
}
