package org.github.cache

import net.oschina.j2cache.CacheChannel
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired

abstract class AbstractJ2Cache<E, R>: J2CacheSupplier<E, R>,InitializingBean {
  @Autowired
  private lateinit var cacheChannel: CacheChannel

  override val channel: CacheChannel get() = cacheChannel

  override fun afterPropertiesSet() = loadAll()
}
