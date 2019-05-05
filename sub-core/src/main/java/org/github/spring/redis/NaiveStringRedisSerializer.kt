package org.github.spring.redis

import org.springframework.data.redis.serializer.RedisSerializer

class NaiveStringRedisSerializer: RedisSerializer<Any?> {
  override fun serialize(any: Any?) = any?.toString()?.toByteArray()

  override fun deserialize(bytes: ByteArray?) = bytes?.let { String(it) }
}
