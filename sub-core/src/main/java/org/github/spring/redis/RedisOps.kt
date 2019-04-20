package org.github.spring.redis

import org.springframework.data.redis.core.HashOperations
import org.springframework.data.redis.core.ListOperations
import org.springframework.data.redis.core.RedisOperations
import org.springframework.data.redis.core.SetOperations
import org.springframework.data.redis.core.StringRedisTemplate
import org.springframework.data.redis.core.ValueOperations
import org.springframework.data.redis.core.ZSetOperations

class StringRedisOps(template: StringRedisTemplate): RedisOperations<String, String> by template

class StringValueOps(template: StringRedisTemplate): ValueOperations<String, String> by template.opsForValue()

class StringSetOps(template: StringRedisTemplate): SetOperations<String, String> by template.opsForSet()

class StringZsetOps(template: StringRedisTemplate): ZSetOperations<String, String> by template.opsForZSet()

class StringListOps(template: StringRedisTemplate): ListOperations<String, String> by template.opsForList()

class StringHashOps(template: StringRedisTemplate): HashOperations<String, String, String> by template.opsForHash<String, String>()
