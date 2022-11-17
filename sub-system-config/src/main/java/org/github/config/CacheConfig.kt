package org.github.config

import com.alibaba.cloud.nacos.NacosPropertySourceRepository.getAll
import net.oschina.j2cache.J2CacheBuilder
import net.oschina.j2cache.J2CacheBuilder.init
import net.oschina.j2cache.J2CacheConfig
import net.oschina.j2cache.J2CacheConfig.initFromConfig
import org.github.cache.EnumCache
import org.github.cache.RAMCache
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.MapPropertySource
import java.util.*

@Configuration
class CacheConfig {
  @Bean
  fun j2CacheBuilder(): J2CacheBuilder {
    return init(j2CacheConfig())
  }

  @Bean
  fun j2CacheConfig(): J2CacheConfig {
    val source: MapPropertySource = getAll().first {it.dataId.contains("j2cache-.*\\.properties".toRegex())}
    val properties = Properties().apply {putAll(source.source)}
    return initFromConfig(properties)
  }

  @Bean
  fun j2CacheManager(): J2CacheManager {
    return J2CacheManager()
  }

  @Bean
  fun enumCache() = EnumCache("org.github")

  @Bean
  fun ramCache() = RAMCache()
}
