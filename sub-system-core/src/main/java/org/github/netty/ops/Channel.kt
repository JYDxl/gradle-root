package org.github.netty.ops

import io.netty.channel.Channel
import io.netty.util.Attribute
import io.netty.util.AttributeKey
import io.netty.util.AttributeKey.newInstance

val KEY_MARK: AttributeKey<Mark> = newInstance("MARK")

val Channel.hasMark get() = hasAttr(KEY_MARK)

val Channel.mark: Attribute<Mark> get() = attr(KEY_MARK)

val Channel.info get() = "MARK: ${if (hasMark) mark.get() else null}"
