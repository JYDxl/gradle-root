package org.github.spring.redis.ops

import org.springframework.core.io.Resource
import org.springframework.data.redis.core.*
import org.springframework.data.redis.core.script.DefaultRedisScript
import org.springframework.data.redis.core.script.RedisScript
import kotlin.reflect.KClass

class StringRedisOps(template: RedisTemplate<String, String>): RedisOperations<String, String> by template

class StringValueOps(redisOps: StringRedisOps): ValueOperations<String, String> by redisOps.opsForValue()

class StringSetOps(redisOps: StringRedisOps): SetOperations<String, String> by redisOps.opsForSet()

class StringZsetOps(redisOps: StringRedisOps): ZSetOperations<String, String> by redisOps.opsForZSet()

class StringListOps(redisOps: StringRedisOps): ListOperations<String, String> by redisOps.opsForList()

class StringHashOps(redisOps: StringRedisOps): HashOperations<String, String, String> by redisOps.opsForHash()

class StringGeoOps(redisOps: StringRedisOps): GeoOperations<String, String> by redisOps.opsForGeo()

class StringClusterOps(redisOps: StringRedisOps): ClusterOperations<String, String> by redisOps.opsForCluster()

class StringHyperLogLogOps(redisOps: StringRedisOps): HyperLogLogOperations<String, String> by redisOps.opsForHyperLogLog()

class StringRedisScript(resource: Resource): RedisScript<String> by newRedisScript(String::class, resource)

class LongRedisScript(resource: Resource): RedisScript<Long> by newRedisScript(Long::class, resource)

@Suppress("UNCHECKED_CAST")
class ListRedisScript(resource: Resource): RedisScript<List<String?>> by newRedisScript(List::class, resource) as RedisScript<List<String?>>

fun <T: Any> newRedisScript(clazz: KClass<T>? = null, resource: Resource) = DefaultRedisScript<T>().apply {clazz?.java?.let {resultType = it}; setLocation(resource)}
