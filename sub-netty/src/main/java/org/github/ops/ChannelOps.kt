package org.github.ops

import io.netty.channel.Channel
import io.netty.util.AttributeKey

private val attrId: AttributeKey<String> = AttributeKey.valueOf("id")

fun Channel.hasId() = hasAttr(attrId)

val Channel.ID get() = attr(attrId).get()!!

val Channel.fixedID get() = ID.padStart(20)

fun Channel.setId(id: String) = attr(attrId).set(id)
