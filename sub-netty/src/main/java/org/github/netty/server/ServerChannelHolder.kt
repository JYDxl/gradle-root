package org.github.netty.server

import io.netty.channel.Channel
import org.springframework.beans.factory.DisposableBean

class ServerChannelHolder(private val channel: Channel) : DisposableBean {
  override fun destroy() {
    channel.close()
  }
}
