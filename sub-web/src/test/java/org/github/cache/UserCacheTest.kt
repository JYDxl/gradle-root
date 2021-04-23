package org.github.cache

import lombok.extern.slf4j.Slf4j
import org.github.base.entity.UserEntity
import org.github.ops.info
import org.github.ops.log
import org.junit.jupiter.api.MethodOrderer.OrderAnnotation
import org.junit.jupiter.api.Order
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.TestMethodOrder
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@TestMethodOrder(OrderAnnotation::class)
@ExtendWith(SpringExtension::class)
@SpringBootTest
@Slf4j
internal class UserCacheTest {
    private val log = UserCache::class.log

    @Autowired
    private lateinit var userCache: UserCache

    @Order(1)
    @Test
    fun testGet() {
        val user1 = userCache.get("10")
        log.info { user1 }
        val user2 = userCache.get(null)
        log.info { user2 }
    }

    @Order(2)
    @Test
    fun testGetSome() {
        val map = userCache.getSome(listOf("1", "10", "1000"))
        log.info { map }
    }

    @Order(3)
    @Test
    fun testGetAll() {
        val map = userCache.getAll()
        log.info { map }
    }

    @Order(4)
    @Test
    fun testSet() {
        userCache.set("userId1", UserEntity())
        userCache.set("userId2", null)
    }

    @Order(5)
    @Test
    fun testSetSome() {
        userCache.setSome(mapOf("1" to null, "2" to UserEntity()))
    }

    @Order(6)
    @Test
    fun testDel() {
        userCache.del("1", "10", "100", "1000", "10000")
    }

    @Order(7)
    @Test
    fun testDelAll() {
        userCache.delAll()
    }
}
