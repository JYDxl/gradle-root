package org.github.cache

import net.oschina.j2cache.CacheChannel
import net.oschina.j2cache.J2CacheBuilder
import org.springframework.beans.factory.annotation.Autowired

abstract class AbstractJ2Cache<E, R>: J2CacheSupplier<E, R> {
  @Autowired
  private lateinit var j2CacheBuilder: J2CacheBuilder

  override val channel: CacheChannel get() = j2CacheBuilder.channel
}
