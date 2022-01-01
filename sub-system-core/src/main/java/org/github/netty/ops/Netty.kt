package org.github.netty.ops

import io.netty.channel.Channel
import io.netty.channel.MultithreadEventLoopGroup
import io.netty.channel.ServerChannel
import io.netty.channel.epoll.Epoll.isAvailable
import io.netty.channel.epoll.EpollEventLoopGroup
import io.netty.channel.epoll.EpollServerSocketChannel
import io.netty.channel.epoll.EpollSocketChannel
import io.netty.channel.group.ChannelMatcher
import io.netty.channel.group.ChannelMatchers.compose
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import java.util.concurrent.ThreadFactory

val serverSocketChannel: Class<out ServerChannel>
  get() = when {
    isAvailable() -> EpollServerSocketChannel::class.java
    else          -> NioServerSocketChannel::class.java
  }

val socketChannel: Class<out Channel>
  get() = when {
    isAvailable() -> EpollSocketChannel::class.java
    else          -> NioSocketChannel::class.java
  }

fun eventLoopGroup(threads: Int, factory: ThreadFactory): MultithreadEventLoopGroup {
  return when {
    isAvailable() -> EpollEventLoopGroup(threads, factory)
    else          -> NioEventLoopGroup(threads, factory)
  }
}

val isWriteable get() = ChannelMatcher {it.isWritable}

val isActive get() = ChannelMatcher {it.isActive}

val ChannelMatcher.andIsWriteable: ChannelMatcher get() = compose(this, isWriteable)

val ChannelMatcher.andIsActive: ChannelMatcher get() = compose(this, isActive)
