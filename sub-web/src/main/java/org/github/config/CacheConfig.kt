package org.github.config

import net.oschina.j2cache.CacheChannel
import net.oschina.j2cache.J2Cache.getChannel
import org.github.cache.UserCache
import org.github.system.EnumCache
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CacheConfig {
  @Bean
  fun cacheChannel(): CacheChannel = getChannel()

  @Bean
  fun userCache() = UserCache()

  @Bean
  fun enumCache() = EnumCache("org.github.base.enums")
}
