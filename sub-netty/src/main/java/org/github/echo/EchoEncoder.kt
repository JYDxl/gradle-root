package org.github.echo

import io.netty.channel.ChannelHandler.Sharable
import io.netty.channel.ChannelHandlerContext
import io.netty.handler.codec.string.StringEncoder

@Sharable
class EchoEncoder: StringEncoder(Charsets.UTF_8) {
  /** 分隔符. */
  private val delimiter = '\n'

  override fun encode(ctx: ChannelHandlerContext, msg: CharSequence, out: MutableList<Any>) {
    super.encode(ctx, msg, out)
    if(msg.endsWith(delimiter)) return
    out += ctx.alloc().buffer(1).writeByte(delimiter.toInt())
  }
}
