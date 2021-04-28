package org.github.cache

import net.oschina.j2cache.CacheChannel
import java.util.function.Function
import java.util.function.Supplier

interface CacheSupplier<V>: Function<String, V?>, Supplier<Map<String, V?>> {
  val region: Supplier<String>

  val channel: CacheChannel

  @Suppress("UNCHECKED_CAST")
  fun get(key: Any?): V? = if (key == null) null else channel.get(region.get(), key.toString(), {apply(key.toString())}).value as V?

  @Suppress("UNCHECKED_CAST")
  fun getSome(keys: Collection<String>): Map<String, V?> = channel.get(region.get(), keys, this::apply).mapValues {it.value.value as V?}

  @Suppress("UNCHECKED_CAST")
  fun getAll(): Map<String, V?> = channel.get(region.get(), channel.keys(region.get())).mapValues {it.value.value as V?}

  fun set(key: Any, value: V?) = channel.set(region.get(), key.toString(), value)

  fun setSome(values: Map<String, V?>) = channel.set(region.get(), values)

  fun del(vararg keys: String) = channel.evict(region.get(), *keys)

  fun delAll() = channel.clear(region.get())
}
