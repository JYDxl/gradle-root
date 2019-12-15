package org.github.netty.ops

import io.netty.buffer.ByteBufAllocator
import io.netty.buffer.PooledByteBufAllocator
import io.netty.buffer.UnpooledByteBufAllocator
import io.netty.channel.Channel
import io.netty.util.Attribute
import io.netty.util.AttributeKey

val KEY_MARK: AttributeKey<String> = AttributeKey.newInstance("mark")

val ALLOC get() = ByteBufAllocator.DEFAULT!!

val ALLOC_POOLED get() = PooledByteBufAllocator.DEFAULT!!

val ALLOC_UNPOOLED get() = UnpooledByteBufAllocator.DEFAULT!!

val Channel.hasMark get() = hasAttr(KEY_MARK)

val Channel.mark: Attribute<String> get() = attr(KEY_MARK)

val Channel.info get() = "[MARK:${if(hasMark) mark.get() else null}]"
