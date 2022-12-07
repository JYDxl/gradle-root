package org.github.common.config

import com.alicp.jetcache.anno.config.EnableMethodCache
import org.github.cache.EnumCache
import org.github.cache.RAMCache
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@EnableMethodCache(basePackages = ["org.github"])
@Configuration
class CacheConfig {
  @Bean
  fun enumCache() = EnumCache("org.github")

  @Bean
  fun ramCache() = RAMCache()
}
