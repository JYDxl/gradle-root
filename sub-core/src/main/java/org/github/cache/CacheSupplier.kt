package org.github.cache

import net.oschina.j2cache.CacheChannel
import java.util.function.Function
import java.util.function.Supplier

interface CacheSupplier<V>: Function<String, V?>, Supplier<Map<String, V?>> {
  val region: CacheNameSupplier

  val channel: CacheChannel

  val prefix: String get() = "j2cache:"

  override fun get(): Map<String, V?>

  override fun apply(key: String): V?

  @Suppress("UNCHECKED_CAST", "DEPRECATION")
  fun get(key: Any?): V? = if (key == null) null else channel.get(region.apply(prefix), key.toString(), {apply(key.toString())}).value as V?

  @Suppress("UNCHECKED_CAST", "DEPRECATION")
  fun getSome(keys: Collection<String>): Map<String, V?> = channel.get(region.apply(prefix), keys, this::apply).mapValues {it.value.value as V?}

  @Suppress("UNCHECKED_CAST")
  fun getAll(): Map<String, V?> = channel.get(region.apply(prefix), channel.keys(region.apply(prefix))).mapValues {it.value.value as V?}

  fun set(key: Any, value: V?) = channel.set(region.apply(prefix), key.toString(), value)

  fun setSome(values: Map<String, V?>) = channel.set(region.apply(prefix), values)

  fun del(vararg keys: String) = channel.evict(region.apply(prefix), *keys)

  fun delAll() = channel.clear(region.apply(prefix))
}
