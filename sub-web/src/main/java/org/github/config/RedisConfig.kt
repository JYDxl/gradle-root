package org.github.config

import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.data.redis.connection.RedisConnectionFactory
import org.springframework.data.redis.core.GeoOperations
import org.springframework.data.redis.core.HyperLogLogOperations
import org.springframework.data.redis.core.ListOperations
import org.springframework.data.redis.core.SetOperations
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.data.redis.core.ZSetOperations
import org.springframework.data.redis.serializer.RedisSerializer

@Configuration
class RedisConfig(private val factory: RedisConnectionFactory) {
  @Bean
  fun redisTemplate() = StringRedisTemplate().apply {
    setConnectionFactory(factory)
    setDefaultSerializer(RedisSerializer.string())
    setEnableTransactionSupport(true)
  }

  @Bean
  fun zsetOps(): ZSetOperations<String, String?> = redisTemplate().opsForZSet()

  @Bean
  fun listOps(): ListOperations<String, String?> = redisTemplate().opsForList()

  @Bean
  fun setOps(): SetOperations<String, String?> = redisTemplate().opsForSet()

  @Bean
  fun valOps(): ValueOperations<String, String> = redisTemplate().opsForValue()

  @Bean
  fun geoOps(): GeoOperations<String, String> = redisTemplate().opsForGeo()

  @Bean
  fun hllOps(): HyperLogLogOperations<String, String?> = redisTemplate().opsForHyperLogLog()
}
