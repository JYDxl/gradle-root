package org.github.netty.ops

import io.netty.channel.Channel
import io.netty.util.Attribute
import io.netty.util.AttributeKey

val KEY_MARK: AttributeKey<String> = AttributeKey.newInstance("mark")

val Channel.hasMark get() = hasAttr(KEY_MARK)

val Channel.mark: Attribute<String> get() = attr(KEY_MARK)

val Channel.info get() = "[MARK:${if(hasMark) mark.get() else null}]"
