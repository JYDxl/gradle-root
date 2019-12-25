package org.github.netty.ops

import io.netty.channel.Channel
import io.netty.channel.ServerChannel
import io.netty.channel.epoll.Epoll
import io.netty.channel.epoll.EpollEventLoopGroup
import io.netty.channel.epoll.EpollServerSocketChannel
import io.netty.channel.epoll.EpollSocketChannel
import io.netty.channel.group.ChannelGroup
import io.netty.channel.group.ChannelMatcher
import io.netty.channel.group.ChannelMatchers.*
import io.netty.channel.kqueue.KQueue
import io.netty.channel.kqueue.KQueueEventLoopGroup
import io.netty.channel.kqueue.KQueueServerSocketChannel
import io.netty.channel.kqueue.KQueueSocketChannel
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import java.util.concurrent.ThreadFactory

val serverSocketChannel: Class<out ServerChannel>
  get() = when {
    Epoll.isAvailable()  -> EpollServerSocketChannel::class.java
    KQueue.isAvailable() -> KQueueServerSocketChannel::class.java
    else                 -> NioServerSocketChannel::class.java
  }

val socketChannel: Class<out Channel>
  get() = when {
    Epoll.isAvailable()  -> EpollSocketChannel::class.java
    KQueue.isAvailable() -> KQueueSocketChannel::class.java
    else                 -> NioSocketChannel::class.java
  }

fun eventLoopGroup(threads: Int, threadFactory: ThreadFactory) = when {
  Epoll.isAvailable()  -> EpollEventLoopGroup(threads, threadFactory)
  KQueue.isAvailable() -> KQueueEventLoopGroup(threads, threadFactory)
  else                 -> NioEventLoopGroup(threads, threadFactory)
}

fun ChannelGroup.findChannel(matcher: ChannelMatcher): Boolean {
  forEach { if(matcher.matches(it)) return true }
  return false
}

val isWriteable get() = ChannelMatcher { it.isWritable }

val ChannelMatcher.withWriteable: ChannelMatcher get() = compose(this, isWriteable)
