package org.github.ops

import io.netty.channel.ChannelFuture

fun ChannelFuture.pushListener(listener: (ChannelFuture) -> Unit) = addListener { listener(it as ChannelFuture) }!!
