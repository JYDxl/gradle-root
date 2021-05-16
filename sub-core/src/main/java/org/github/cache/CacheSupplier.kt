package org.github.cache

import cn.hutool.core.lang.Pair
import org.github.util.FuncUtil.optional
import org.github.util.FuncUtil.pass
import java.util.function.Consumer
import java.util.function.Function
import java.util.function.Predicate
import java.util.function.Supplier

interface CacheSupplier<E, R>: Function<String, E?>, Supplier<Map<String, E?>>, Consumer<CacheEvent> {
  val region: CacheNameSupplier

  val filter: Predicate<E> get() = pass()

  val mapper: Function<E?, R?>

  val proxy: Function<E?, R?> get() = optional(mapper, null)

  override fun get(): Map<String, E?>

  override fun apply(key: String): E?

  override fun accept(event: CacheEvent) = Unit

  fun get(key: Any?): R? = if (key == null) null else proxy.apply(apply(key.toString()))

  fun getSome(keys: Collection<String>): Map<String, R?> = get().filterKeys {keys.contains(it)}.mapValues {proxy.apply(it.value)}

  fun getAll(): List<Pair<String, R>> = getAll(filter)

  fun getAll(filter: Predicate<E>): List<Pair<String, R>> = get().filterValues {it != null && filter.test(it)}.mapTo(arrayListOf()) {Pair<String, R>(it.key, proxy.apply(it.value))}

  fun set(key: Any) = Unit

  fun setSome(keys: Collection<String>) = Unit

  fun del(vararg keys: String) = Unit

  fun delAll() = Unit

  fun load() = Unit
}
