package org.github.ops

import io.netty.channel.Channel
import io.netty.util.Attribute
import io.netty.util.AttributeKey

val KEY_MARK: AttributeKey<String> = AttributeKey.newInstance("mark")

fun Channel.hasMark() = hasAttr(KEY_MARK) && mark.get() != null

val Channel.mark: Attribute<String> get() = attr(KEY_MARK)

val Channel.markInfo: String get() = "[MARK:${(mark.get() ?: remoteAddress())}]"
