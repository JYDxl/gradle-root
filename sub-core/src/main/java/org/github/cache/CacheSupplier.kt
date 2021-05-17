package org.github.cache

import cn.hutool.core.lang.Pair
import com.google.common.collect.ImmutableList.of
import org.github.util.FuncUtil.*
import org.springframework.beans.factory.InitializingBean
import java.util.function.Consumer
import java.util.function.Function
import java.util.function.Predicate

interface CacheSupplier<E, R>: Function<String, E?>, Consumer<CacheEvent>, InitializingBean {
  val name: CacheNameSupplier

  val filter: Predicate<E?> get() = nonNull()

  val mapper: Function<E?, R?>

  val proxy: Function<E?, R?> get() = optional(mapper, null)

  fun load(keys: Collection<String> = of()): Map<String, E?>

  override fun apply(key: String): E?

  override fun accept(event: CacheEvent) = Unit

  fun get(key: Any?): R? = if (key == null) null else proxy.apply(apply(key.toString()))

  fun getSome(keys: Collection<String>): Map<String, R?> = load(keys).mapValues {proxy.apply(it.value)}

  fun getAll(): List<Pair<String, R>> = getAll(filter)

  fun getAll(filter: Predicate<E?>): List<Pair<String, R>> = load().filterValues {filter.test(it)}.mapTo(arrayListOf()) {Pair<String, R>(it.key, proxy.apply(it.value))}

  fun set(key: Any) = Unit

  fun setSome(keys: Collection<String>) = Unit

  fun del(vararg keys: String) = Unit

  fun delAll() = Unit

  fun loadAll() = Unit

  override fun afterPropertiesSet() = loadAll()
}
