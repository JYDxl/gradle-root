package org.github.config

import net.oschina.j2cache.CacheChannel
import net.oschina.j2cache.J2Cache.getChannel
import org.github.cache.EnumCache
import org.github.cache.RAMCache
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CacheConfig {
  @Bean
  fun cacheChannel(): CacheChannel = getChannel()

  @Bean
  fun enumCache() = EnumCache("org.github")

  @Bean
  fun ramCache() = RAMCache()
}
