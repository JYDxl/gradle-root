package org.github.config

import com.alibaba.cloud.nacos.NacosPropertySourceRepository.getAll
import net.oschina.j2cache.CacheChannel
import net.oschina.j2cache.J2CacheBuilder
import net.oschina.j2cache.J2CacheBuilder.init
import net.oschina.j2cache.J2CacheConfig
import net.oschina.j2cache.J2CacheConfig.initFromConfig
import org.github.cache.EnumCache
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.env.MapPropertySource
import java.util.*

@Configuration
class CacheConfig {
  @Bean
  fun cacheChannel(): CacheChannel {
    val source: MapPropertySource = getAll().first {it.dataId.contains("j2cache-.*\\.properties".toRegex())}
    val properties = Properties().apply {putAll(source.source)}
    val config: J2CacheConfig = initFromConfig(properties)
    val builder: J2CacheBuilder = init(config)
    return builder.channel
  }

  @Bean
  fun enumCache() = EnumCache("org.github")

  // @Bean
  // fun ramCache() = RAMCache()
}
