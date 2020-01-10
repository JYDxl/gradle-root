package org.github.netty.group

import io.netty.buffer.ByteBuf
import io.netty.channel.Channel
import io.netty.channel.group.ChannelGroup
import io.netty.channel.group.ChannelMatcher
import java.util.concurrent.ScheduledExecutorService
import java.util.function.Supplier

interface NativeChannelGroup: ChannelGroup, ScheduledExecutorService {
  fun findChannel(matcher: ChannelMatcher): Channel?

  fun findChannels(matcher: ChannelMatcher): List<Channel>

  fun writeAndFlush(matcher: ChannelMatcher, message: Supplier<ByteBuf>)
}
