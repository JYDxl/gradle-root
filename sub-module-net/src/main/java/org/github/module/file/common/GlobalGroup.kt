package org.github.module.file.common

import io.netty.channel.Channel
import io.netty.channel.ChannelFuture
import io.netty.channel.group.ChannelGroupFutureListener
import io.netty.channel.group.DefaultChannelGroup
import io.netty.util.concurrent.GlobalEventExecutor.INSTANCE
import org.github.netty.ops.hasMark
import org.github.netty.ops.info
import org.github.netty.ops.mark
import org.github.ops.log
import org.github.ops.warn
import org.springframework.stereotype.Component

@Component
class GlobalGroup: DefaultChannelGroup("global-group", INSTANCE) {
  override fun add(element: Channel): Boolean {
    if (!element.hasMark) return false
    val id = element.mark.id
    close {it.hasMark && it.mark.id == id && it !== element}.addListener(ChannelGroupFutureListener {
      for (ch: ChannelFuture in it) {
        log.warn {"对象【${ch.channel().info}】已登录,关闭重复登录的对象"}
      }
    })
    return super.add(element)
  }

  companion object {
    private val log = GlobalGroup::class.log
  }
}
