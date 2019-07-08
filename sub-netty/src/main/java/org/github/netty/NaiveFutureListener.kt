package org.github.netty

import io.netty.channel.ChannelFuture
import io.netty.util.concurrent.GenericFutureListener

interface NaiveFutureListener: GenericFutureListener<ChannelFuture> {
  override fun operationComplete(future: ChannelFuture)
}
