package org.github.spring.redis

import org.springframework.data.redis.core.HashOperations
import org.springframework.data.redis.core.ListOperations
import org.springframework.data.redis.core.RedisOperations
import org.springframework.data.redis.core.RedisTemplate
import org.springframework.data.redis.core.SetOperations
import org.springframework.data.redis.core.ValueOperations
import org.springframework.data.redis.core.ZSetOperations

class StringRedisOps(template: RedisTemplate<String, String>): RedisOperations<String, String> by template

class StringValueOps(redisOps: StringRedisOps): ValueOperations<String, String> by redisOps.opsForValue()

class StringSetOps(redisOps: StringRedisOps): SetOperations<String, String> by redisOps.opsForSet()

class StringZsetOps(redisOps: StringRedisOps): ZSetOperations<String, String> by redisOps.opsForZSet()

class StringListOps(redisOps: StringRedisOps): ListOperations<String, String> by redisOps.opsForList()

class StringHashOps(redisOps: StringRedisOps): HashOperations<String, String, String> by redisOps.opsForHash<String, String>()
