package org.github.cache

import net.oschina.j2cache.CacheChannel
import org.springframework.beans.factory.annotation.Autowired

abstract class AbstractCacheSupplier<V>: CacheSupplier<V> {
  @Autowired
  private lateinit var cacheChannel: CacheChannel

  override val channel: CacheChannel get() = cacheChannel

  @Deprecated("")
  abstract override fun get(): Map<String, V?>

  @Deprecated("")
  abstract override fun apply(key: String): V?
}
