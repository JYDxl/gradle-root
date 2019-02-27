package org.github.netty.socket

import io.netty.channel.Channel
import io.netty.channel.socket.nio.NioSocketChannel
import java.nio.channels.SocketChannel
import java.nio.channels.spi.SelectorProvider
import java.util.UUID.randomUUID

class NaiveNioSocketChannel : NioSocketChannel {
  constructor()

  constructor(provider: SelectorProvider) : super(provider)

  constructor(socket: SocketChannel) : super(socket)

  constructor(parent: Channel, socket: SocketChannel) : super(parent, socket)

  override fun newId() = NaiveChannelId("naive-nio", randomUUID().toString())
}
