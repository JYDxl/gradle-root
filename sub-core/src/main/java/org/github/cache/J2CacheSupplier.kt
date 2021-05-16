package org.github.cache

import cn.hutool.core.lang.Pair
import net.oschina.j2cache.CacheChannel
import org.github.cache.CacheStatus.*
import java.util.function.Predicate

interface J2CacheSupplier<E, R>: CacheSupplier<E, R> {
  val channel: CacheChannel

  val prefix: String get() = "j2cache:"

  override fun get(): Map<String, E?>

  override fun apply(key: String): E?

  override fun accept(event: CacheEvent) {
    val id = event.id
    when (event.status) {
      add    -> set(id)
      modify -> set(id)
      delete -> del(id)
    }
  }

  @Suppress("UNCHECKED_CAST")
  override fun get(key: Any?): R? = if (key == null) null else proxy.apply(channel.get(region.apply(prefix), key.toString(), {apply(key.toString())}).value as E?)

  @Suppress("UNCHECKED_CAST")
  override fun getSome(keys: Collection<String>): Map<String, R?> = channel.get(region.apply(prefix), keys, this::apply).mapValues {proxy.apply(it.value.value as E?)}

  @Suppress("UNCHECKED_CAST")
  override fun getAll(filter: Predicate<E>): List<Pair<String, R>> = channel.get(region.apply(prefix), channel.keys(region.apply(prefix))).filterValues {it.value != null && filter.test(it.value as E)}.mapTo(arrayListOf()) {Pair<String, R>(it.key, proxy.apply(it.value.value as E))}

  override fun set(key: Any) = channel.set(region.apply(prefix), key.toString(), apply(key.toString()))

  override fun setSome(keys: Collection<String>) = channel.set(region.apply(prefix), get().filterKeys {keys.contains(it)})

  override fun del(vararg keys: String) = channel.evict(region.apply(prefix), *keys)

  override fun delAll() = channel.clear(region.apply(prefix))

  override fun load() = channel.set(region.apply(prefix), get())
}
