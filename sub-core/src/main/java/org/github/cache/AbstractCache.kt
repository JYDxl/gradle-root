package org.github.cache

import net.oschina.j2cache.CacheChannel
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired

abstract class AbstractCache<V>: CacheSupplier<V>, InitializingBean {
  @Autowired
  private lateinit var cacheChannel: CacheChannel

  override val channel: CacheChannel get() = cacheChannel

  @Deprecated("")
  @Suppress("DEPRECATION")
  override fun afterPropertiesSet() = setSome(get())
}
