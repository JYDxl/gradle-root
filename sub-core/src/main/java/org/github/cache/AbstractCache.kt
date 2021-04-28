package org.github.cache

import net.oschina.j2cache.CacheChannel
import org.springframework.beans.factory.DisposableBean
import org.springframework.beans.factory.InitializingBean
import org.springframework.beans.factory.annotation.Autowired

abstract class AbstractCache<V>: CacheSupplier<V>, InitializingBean, DisposableBean {
  @Autowired
  private lateinit var cacheChannel: CacheChannel

  override val channel: CacheChannel get() = cacheChannel

  @Suppress("DEPRECATION")
  abstract override fun get(): Map<String, V?>

  @Suppress("DEPRECATION")
  abstract override fun apply(key: String): V?

  @Suppress("DEPRECATION")
  override fun afterPropertiesSet() = setSome(get())

  @Suppress("DEPRECATION")
  override fun destroy() = delAll()
}
