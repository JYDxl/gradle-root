package org.github.netty.ops

import io.netty.channel.Channel
import io.netty.util.Attribute
import io.netty.util.AttributeKey
import io.netty.util.AttributeKey.newInstance

val KEY_MARK: AttributeKey<Mark> = newInstance("MARK")

val Channel.hasMark get() = hasAttr(KEY_MARK)

val Channel.markAttr: Attribute<Mark> get() = attr(KEY_MARK)

val Channel.mark: Mark get() = markAttr.get()

val Channel.info get() = (if (hasMark) mark.toString() else toString())

val KEY_GROUP: AttributeKey<Group> = newInstance("GROUP")

val Channel.hasGroup get() = hasAttr(KEY_GROUP)

val Channel.groupAttr: Attribute<Group> get() = attr(KEY_GROUP)

val Channel.group: Group get() = groupAttr.get()
