package org.github.cache

import net.oschina.j2cache.CacheChannel
import org.springframework.beans.factory.annotation.Autowired

abstract class AbstractJ2Cache<V, E>: J2CacheSupplier<V, E> {
  @Autowired
  private lateinit var cacheChannel: CacheChannel

  override val channel: CacheChannel get() = cacheChannel
}
