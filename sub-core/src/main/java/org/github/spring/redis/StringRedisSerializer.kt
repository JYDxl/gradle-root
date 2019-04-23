package org.github.spring.redis

import org.springframework.data.redis.serializer.RedisSerializer

class StringRedisSerializer: RedisSerializer<Any?> {
  override fun serialize(any: Any?) = any?.toString()?.toByteArray()

  override fun deserialize(bytes: ByteArray?) = bytes?.let { String(it) }
}
