package org.github.ops

import io.netty.channel.ChannelFuture
import org.github.netty.NaiveFutureListener

fun ChannelFuture.putListener(listener: (ChannelFuture) -> Unit) = addListener { listener(it as ChannelFuture) }!!

fun ChannelFuture.putListener(listener: NaiveFutureListener) = addListener(listener)!!

fun ChannelFuture.putListeners(listeners: Array<NaiveFutureListener>) = addListeners(*listeners)!!
