package org.github.config

import org.github.spring.redis.ListRedisScript
import org.github.spring.redis.LongRedisScript
import org.github.spring.redis.NativeStringRedisSerializer
import org.github.spring.redis.StringClusterOps
import org.github.spring.redis.StringGeoOps
import org.github.spring.redis.StringHashOps
import org.github.spring.redis.StringHyperLogLogOps
import org.github.spring.redis.StringListOps
import org.github.spring.redis.StringRedisOps
import org.github.spring.redis.StringRedisScript
import org.github.spring.redis.StringSetOps
import org.github.spring.redis.StringValueOps
import org.github.spring.redis.StringZsetOps
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.io.ResourceLoader
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class RedisConfig {
  @Bean
  fun stringRedisOps(factory: RedisConnectionFactory) = RedisTemplate<String, String>().apply {
    setDefaultSerializer(NativeStringRedisSerializer())
    setConnectionFactory(factory)
    afterPropertiesSet()
  }.let { StringRedisOps(it) }

  @Bean
  fun stringValueOps(redisOps: StringRedisOps) = StringValueOps(redisOps)

  @Bean
  fun stringSetOps(redisOps: StringRedisOps) = StringSetOps(redisOps)

  @Bean
  fun stringZsetOps(redisOps: StringRedisOps) = StringZsetOps(redisOps)

  @Bean
  fun stringListOps(redisOps: StringRedisOps) = StringListOps(redisOps)

  @Bean
  fun stringHashOps(redisOps: StringRedisOps) = StringHashOps(redisOps)

  @Bean
  fun stringGeoOps(redisOps: StringRedisOps) = StringGeoOps(redisOps)

  @Bean
  fun stringClusterOps(redisOps: StringRedisOps) = StringClusterOps(redisOps)

  @Bean
  fun stringHyperLogLogOps(redisOps: StringRedisOps) = StringHyperLogLogOps(redisOps)

  @Bean
  fun boolScript(loader: ResourceLoader) = StringRedisScript(loader.getResource("classpath:lua/redis_string.lua"))

  @Bean
  fun voidScript(loader: ResourceLoader) = StringRedisScript(loader.getResource("classpath:lua/redis_void.lua"))

  @Bean
  fun longScript(loader: ResourceLoader) = LongRedisScript(loader.getResource("classpath:lua/redis_long.lua"))

  @Bean
  fun listScript(loader: ResourceLoader) = ListRedisScript(loader.getResource("classpath:lua/redis_list.lua"))
}
