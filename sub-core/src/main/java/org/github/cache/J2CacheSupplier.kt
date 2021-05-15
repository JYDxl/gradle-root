package org.github.cache

import cn.hutool.core.lang.Pair
import net.oschina.j2cache.CacheChannel
import org.github.cache.CacheStatus.*

interface J2CacheSupplier<V,E>: CacheSupplier<V,E> {

  val channel: CacheChannel

  val prefix: String get() = "j2cache:"

  override fun get(): Map<String, V?>

  override fun apply(key: String): V?

  override fun accept(event: CacheEvent<E>) {
    val entity = event.entity
    when (event.status) {
      add    -> set(getKey(entity), getValue(entity))
      modify -> set(getKey(entity), getValue(entity))
      delete -> del(getKey(entity))
    }
  }

  @Suppress("UNCHECKED_CAST")
  override fun get(key: Any?): V? = if (key == null) null else channel.get(region.apply(prefix), key.toString(), {apply(key.toString())}).value as V?

  @Suppress("UNCHECKED_CAST")
  override fun getSome(keys: Collection<String>): Map<String, V?> = channel.get(region.apply(prefix), keys, this::apply).mapValues {it.value.value as V?}

  @Suppress("UNCHECKED_CAST")
  override fun getAll(): List<Pair<String, V?>> = channel.get(region.apply(prefix), channel.keys(region.apply(prefix))).mapValues { it.value.value as V? }.mapTo(arrayListOf()) { Pair<String, V?>(it.key, it.value) }

  override fun set(key: Any, value: V?) = channel.set(region.apply(prefix), key.toString(), value)

  override fun setSome(values: Map<String, V?>) = channel.set(region.apply(prefix), values)

  override fun del(vararg keys: String) = channel.evict(region.apply(prefix), *keys)

  override fun delAll() = channel.clear(region.apply(prefix))

  override fun loadAll() = setSome(get())
}
