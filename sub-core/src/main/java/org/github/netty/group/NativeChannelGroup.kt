package org.github.netty.group

import io.netty.channel.Channel
import io.netty.channel.group.ChannelGroup
import io.netty.channel.group.ChannelMatcher

interface NativeChannelGroup: ChannelGroup {
  fun findChannel(matcher: ChannelMatcher): Channel?

  fun findChannels(matcher: ChannelMatcher): List<Channel>
}
