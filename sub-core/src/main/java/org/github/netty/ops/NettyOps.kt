package org.github.netty.ops

import io.netty.channel.ChannelFutureListener
import io.netty.channel.ServerChannel
import io.netty.channel.epoll.EpollEventLoopGroup
import io.netty.channel.epoll.EpollServerSocketChannel
import io.netty.channel.epoll.EpollSocketChannel
import io.netty.channel.kqueue.KQueueEventLoopGroup
import io.netty.channel.kqueue.KQueueServerSocketChannel
import io.netty.channel.kqueue.KQueueSocketChannel
import io.netty.channel.nio.NioEventLoopGroup
import io.netty.channel.socket.nio.NioServerSocketChannel
import io.netty.channel.socket.nio.NioSocketChannel
import io.netty.util.concurrent.Future
import io.netty.util.concurrent.GenericFutureListener
import org.github.ops.error
import org.github.ops.log
import java.lang.System.*
import java.util.Locale.*
import java.util.concurrent.ThreadFactory

class NettyOps

val log = NettyOps::class.log

val channelFutureListener: GenericFutureListener<out Future<in Void>> = ChannelFutureListener {
  if(!it.isSuccess) log.error(it.cause()) { it.channel().markInfo }
}

val serverSocketChannel: Class<out ServerChannel>
  get() = when {
    mac   -> KQueueServerSocketChannel::class.java
    linux -> EpollServerSocketChannel::class.java
    else  -> NioServerSocketChannel::class.java
  }

val socketChannel
  get() = when {
    mac   -> KQueueSocketChannel::class.java
    linux -> EpollSocketChannel::class.java
    else  -> NioSocketChannel::class.java
  }

fun eventLoopGroup(threads: Int, threadFactory: ThreadFactory) = when {
  mac   -> KQueueEventLoopGroup(threads, threadFactory)
  linux -> EpollEventLoopGroup(threads, threadFactory)
  else  -> NioEventLoopGroup(threads, threadFactory)
}

internal val os = getProperty("os.name", "").toLowerCase(US)

internal val linux = os.contains("linux")

internal val mac = os.contains("mac")
