package org.github.cache

import net.oschina.j2cache.CacheChannel
import org.springframework.beans.factory.InitializingBean
import java.util.function.Function
import java.util.function.Supplier

interface CacheSupplier<V>: Function<String, V?>, Supplier<Map<String, V?>>, InitializingBean {
  val region: String

  val channel: CacheChannel

  @Suppress("UNCHECKED_CAST")
  fun get(key: Any?): V? = if (key == null) null else channel.get(region, key.toString(), {apply(key.toString())}).value as V?

  fun set(key: Any, value: V?) = channel.set(region, key.toString(), value)

  fun del(key: Any) = channel.evict(region, key.toString())

  fun delAll() = channel.evict(region, *channel.keys(region).toTypedArray())

  @Suppress("UNCHECKED_CAST")
  fun getAll(): Map<String, V?> = channel.get(region, channel.keys(region)).mapValues {it.value.value as V?}

  @Deprecated("")
  override fun afterPropertiesSet() = channel.set(region, get())
}
