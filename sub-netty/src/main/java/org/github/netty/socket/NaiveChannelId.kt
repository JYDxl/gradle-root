package org.github.netty.socket

import io.netty.channel.ChannelId
import org.github.ops.json

class NaiveChannelId(private val id: String, private val uid: String) : ChannelId {
  override fun compareTo(other: ChannelId?) = json().compareTo(other.json())

  override fun asShortText() = id

  override fun asLongText() = uid
}
