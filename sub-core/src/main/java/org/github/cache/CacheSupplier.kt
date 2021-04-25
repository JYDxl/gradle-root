package org.github.cache

import net.oschina.j2cache.CacheChannel
import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.NamedBean
import java.util.function.Function
import java.util.function.Supplier

interface CacheSupplier<V>: Function<String, V?>, Supplier<Map<String, V?>>, InitializingBean, DisposableBean, NamedBean {
  val region: String

  val channel: CacheChannel

  @Suppress("UNCHECKED_CAST")
  fun get(key: Any?): V? = if (key == null) null else channel.get(region, key.toString(), {apply(key.toString())}).value as V?

  @Suppress("UNCHECKED_CAST")
  fun getSome(keys: Collection<String>): Map<String, V?> = channel.get(region, keys, this::apply).mapValues {it.value.value as V?}

  @Suppress("UNCHECKED_CAST")
  fun getAll(): Map<String, V?> = channel.get(region, channel.keys(region)).mapValues {it.value.value as V?}

  fun set(key: Any, value: V?) = channel.set(region, key.toString(), value)

  fun setSome(values: Map<String, V?>) = channel.set(region, values)

  fun del(vararg keys: String) = channel.evict(region, *keys)

  fun delAll() = channel.clear(region)

  @Deprecated("")
  override fun afterPropertiesSet() = setSome(get())

  @Deprecated("")
  override fun destroy() = delAll()

  @Deprecated("")
  override fun getBeanName() = region
}
