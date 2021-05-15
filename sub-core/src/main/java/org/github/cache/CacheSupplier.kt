package org.github.cache

import cn.hutool.core.lang.Pair
import java.util.function.Consumer
import java.util.function.Function
import java.util.function.Supplier

interface CacheSupplier<V, E> : Function<String, V?>, Supplier<Map<String, V?>>, Consumer<CacheEvent<E>> {
  val region: CacheNameSupplier

  override fun get(): Map<String, V?>

  override fun apply(key: String): V?

  override fun accept(event: CacheEvent<E>) = Unit

  fun getKey(entity: E): String

  fun getValue(entity: E): V?

  fun get(key: Any?): V? = if (key == null) null else apply(key.toString())

  fun getSome(keys: Collection<String>): Map<String, V?> = get().filterKeys { keys.contains(it) }

  fun getAll(): List<Pair<String, V?>> = get().filterValues { it != null }.mapTo(arrayListOf()) { Pair<String, V?>(it.key, it.value) }

  fun set(key: Any, value: V?) = Unit

  fun setSome(values: Map<String, V?>) = Unit

  fun del(vararg keys: String) = Unit

  fun delAll() = Unit

  fun loadAll() = Unit
}
