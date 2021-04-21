package org.github.cache

import net.oschina.j2cache.CacheChannel
import org.springframework.beans.factory.InitializingBean
import java.util.function.Function
import java.util.function.Supplier

interface CacheSupplier<V> : Function<String, V?>, Supplier<Map<String, V?>>, InitializingBean {
    val region: String

    val channel: CacheChannel

    val prefix: String get() = region

    @Deprecated("")
    fun key(key: Any) = "$prefix@$key"

    @Suppress("UNCHECKED_CAST", "DEPRECATION")
    fun get(key: Any?): V? =
        if (key == null) null else channel.get(region, key(key), { apply(key.toString()) }).value as V?

    @Suppress("DEPRECATION")
    fun set(key: Any, value: V?) = channel.set(region, key(key), value)

    @Suppress("DEPRECATION")
    fun del(key: Any) = channel.evict(region, key(key))

    @Suppress("UNCHECKED_CAST", "DEPRECATION")
    fun getAll(): Map<String, V?> =
        channel.get(region, channel.keys(region).map { key(it) }).mapValues { it.value.value as V? }

    @Deprecated("")
    override fun afterPropertiesSet() = channel.set(region, get())
}
