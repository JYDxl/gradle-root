package org.github.config

import net.oschina.j2cache.CacheChannel
import net.oschina.j2cache.J2Cache
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class CacheConfig {
    @Bean
    fun cacheChannel(): CacheChannel = J2Cache.getChannel()
}
