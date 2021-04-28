package org.github.netty.group

import io.netty.channel.Channel
import io.netty.channel.group.ChannelGroup
import io.netty.channel.group.ChannelMatcher
import io.netty.channel.group.DefaultChannelGroup
import io.netty.util.concurrent.EventExecutor

class NativeChannelGroupImpl(executor: EventExecutor, name: String = "default-group", stayClosed: Boolean = false): ChannelGroup by DefaultChannelGroup(name, executor, stayClosed), NativeChannelGroup {
  override fun findChannel(matcher: ChannelMatcher): Channel? {
    forEach {if (matcher.matches(it)) return@findChannel it};return null
  }

  override fun findChannels(matcher: ChannelMatcher) = arrayListOf<Channel>().apply {
    forEach {if (matcher.matches(it)) this += it}
  }
}
