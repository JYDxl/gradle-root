package org.github.config

import org.github.spring.redis.StringHashOps
import org.github.spring.redis.StringListOps
import org.github.spring.redis.StringRedisOps
import org.github.spring.redis.StringRedisSerializer
import org.github.spring.redis.StringSetOps
import org.github.spring.redis.StringValueOps
import org.github.spring.redis.StringZsetOps
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.RedisTemplate

@Configuration
class RedisConfig {
  @Bean
  fun stringRedisOps(factory: RedisConnectionFactory) = RedisTemplate<String, String>().apply {
    setDefaultSerializer(StringRedisSerializer())
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
}
