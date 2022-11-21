package org.github.config

import org.github.cache.EnumCache
import org.github.cache.RAMCache
import org.springframework.cache.annotation.EnableCaching
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
@EnableCaching
class CacheConfig {
  @Bean
  fun enumCache() = EnumCache("org.github")

  @Bean
  fun ramCache() = RAMCache()
}
