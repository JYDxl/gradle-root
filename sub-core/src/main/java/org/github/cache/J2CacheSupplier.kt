package org.github.cache

import cn.hutool.core.lang.Pair
import net.oschina.j2cache.CacheChannel
import org.github.cache.CacheStatus.*
import java.util.function.Predicate

interface J2CacheSupplier<E, R>: CacheSupplier<E, R> {
  val channel: CacheChannel

  val prefix: String get() = "j2cache:"

  val region: String get() = name.apply(prefix)

  @Suppress("UNCHECKED_CAST")
  override fun accept(event: CacheEvent) {
    val source = event.source
    val status = event.status
    if (source is Collection<*>) {
      source as Collection<String>
      when (status) {
        add    -> setSome(source)
        modify -> setSome(source)
        delete -> del(*source.toTypedArray())
      }
    } else {
      source as String
      when (status) {
        add    -> set(source)
        modify -> set(source)
        delete -> del(source)
      }
    }
  }

  @Suppress("UNCHECKED_CAST")
  override fun get(key: Any?): R? = if (key == null) null else proxy.apply(channel.get(region, key.toString(), { apply(key.toString()) }).value as E?)

  @Suppress("UNCHECKED_CAST")
  override fun getSome(keys: Collection<String>): Map<String, R?> = channel.get(region, keys, this::apply).mapValues { proxy.apply(it.value.value as E?) }

  @Suppress("UNCHECKED_CAST")
  override fun getAll(filter: Predicate<E?>): List<Pair<String, R>> = channel.get(region, channel.keys(region)).filterValues { filter.test(it.value as E?) }.mapTo(arrayListOf()) { Pair<String, R>(it.key, proxy.apply(it.value.value as E)) }

  override fun set(key: Any) = channel.set(region, key.toString(), apply(key.toString()))

  override fun setSome(keys: Collection<String>) = channel.set(region, load(keys))

  override fun del(vararg keys: String) = channel.evict(region, *keys)

  override fun delAll() = channel.clear(region)

  override fun loadAll() = channel.set(region, load())
}
