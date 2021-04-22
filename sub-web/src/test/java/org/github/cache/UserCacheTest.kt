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

  @Order(5)
  @Test
  fun after() {
    userCache.delAll()
  }

  @Order(4)
  @Test
  fun del() {
    userCache.del("1")
  }

  @Order(3)
  @Test
  fun getAll() {
    val map = userCache.getAll()
    log.info {map}
  }

  @Order(2)
  @Test
  fun set() {
    userCache.set("userId", UserEntity())
  }

  @Order(1)
  @Test
  fun testGet() {
    val user1 = userCache.get("1")
    log.info {user1}
    val user2 = userCache.get("100")
    log.info {user2}
  }
}
