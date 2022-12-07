package org.github.netty.module.chat

import io.netty.channel.ChannelFuture
import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.channel.ChannelInboundHandlerAdapter
import io.netty.channel.group.ChannelGroup
import io.netty.channel.group.ChannelMatchers.all
import io.netty.util.concurrent.Future
import org.github.core.netty.ops.andIsWriteable
import org.github.core.ops.info
import org.github.core.ops.log
import org.github.core.ops.warn

@Sharable
class ChatServerHandler(private val group: ChannelGroup): ChannelInboundHandlerAdapter() {
  override fun channelActive(ctx: ChannelHandlerContext) {
    ctx.channel()!!.apply {
      group.add(this)
      log.info {"用户【${remoteAddress()}】已上线"}
      closeFuture().addListener {it: Future<in Void> ->
        it as ChannelFuture
        log.warn {"用户【${remoteAddress()}】已下线"}
      }
    }
  }

  override fun channelRead(ctx: ChannelHandlerContext, msg: Any) {
    msg as String
    val channel = ctx.channel()!!
    log.info {"用户【${channel.remoteAddress()}】发送信息: $msg"}
    group.writeAndFlush(msg, all().andIsWriteable, true)
  }

  private companion object {
    /** log. */
    private val log = ChatServerHandler::class.log
  }
}
