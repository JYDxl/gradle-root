package org.github.config

import org.github.spring.redis.StringHashOps
import org.github.spring.redis.StringListOps
import org.github.spring.redis.StringRedisOps
import org.github.spring.redis.StringSetOps
import org.github.spring.redis.StringValueOps
import org.github.spring.redis.StringZsetOps
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.core.StringRedisTemplate

@Configuration
class RedisConfig {
  @Bean
  fun stringRedisOps(template: StringRedisTemplate) = StringRedisOps(template)

  @Bean
  fun stringValueOps(template: StringRedisTemplate) = StringValueOps(template)

  @Bean
  fun stringSetOps(template: StringRedisTemplate) = StringSetOps(template)

  @Bean
  fun stringZsetOps(template: StringRedisTemplate) = StringZsetOps(template)

  @Bean
  fun stringListOps(template: StringRedisTemplate) = StringListOps(template)

  @Bean
  fun stringHashOps(template: StringRedisTemplate) = StringHashOps(template)
}
