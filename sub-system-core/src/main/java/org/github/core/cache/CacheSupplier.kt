package org.github.core.cache

import cn.hutool.core.lang.Pair
import com.google.common.collect.ImmutableList.of
import org.github.core.util.FuncUtil.*
import org.springframework.beans.factory.InitializingBean
import java.util.function.Consumer
import java.util.function.Function
import java.util.function.Predicate

interface CacheSupplier<E, R>: Function<String, E?>, Consumer<CacheEvent>, InitializingBean {
  val name: CacheNameSupplier

  val mapper: Function<E?, R?>

  val filter: Predicate<E?> get() = nonNull()

  fun load(keys: Collection<String> = of()): Map<String, E?>

  override fun apply(key: String): E? = load(of(key)).firstNotNullOfOrNull {it.value}

  override fun accept(event: CacheEvent) = Unit

  fun get(key: Any?): R? = if (key == null) null else mapper.apply(apply(key.toString()))

  fun getSome(keys: Collection<String>): Map<String, R?> = load(keys).mapValues {mapper.apply(it.value)}

  fun getAll(): List<Pair<String, R>> = getAll(filter)

  fun getAll(filter: Predicate<E?>): List<Pair<String, R>> = load().filterValues {filter.test(it)}.mapTo(arrayListOf()) {Pair<String, R>(it.key, mapper.apply(it.value))}

  fun set(key: Any) = Unit

  fun setSome(keys: Collection<String>) = Unit

  fun del(vararg keys: String) = Unit

  fun delAll() = Unit

  fun loadAll() = Unit

  override fun afterPropertiesSet() = loadAll()
}
