package org.github.netty.group

import io.netty.buffer.ByteBuf
import io.netty.channel.Channel
import io.netty.channel.group.ChannelGroup
import io.netty.channel.group.ChannelMatcher
import io.netty.channel.group.DefaultChannelGroup
import io.netty.util.concurrent.EventExecutor
import java.util.concurrent.ScheduledExecutorService
import java.util.function.Supplier

class NativeChannelGroupImpl(executor: EventExecutor, name: String = "default-group", stayClosed: Boolean = false): ChannelGroup by DefaultChannelGroup(name, executor, stayClosed), ScheduledExecutorService by executor, NativeChannelGroup {
  override fun findChannel(matcher: ChannelMatcher): Channel? {
    forEach { if(matcher.matches(it)) return@findChannel it };return null
  }

  override fun findChannels(matcher: ChannelMatcher) = arrayListOf<Channel>().apply {
    forEach { if(matcher.matches(it)) this += it }
  }

  override fun writeAndFlush(matcher: ChannelMatcher, message: Supplier<ByteBuf>) {
    execute { writeAndFlush(message.get(), matcher, true) }
  }
}
