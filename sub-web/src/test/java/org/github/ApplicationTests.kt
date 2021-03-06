package org.github

import lombok.extern.slf4j.Slf4j
import org.github.ops.info
import org.github.ops.log
import org.github.ops.spring.webAppCtx
import org.github.spring.redis.StringHashOps
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.extension.ExtendWith
import org.springframework.amqp.core.AmqpTemplate
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit.jupiter.SpringExtension

@ExtendWith(SpringExtension::class)
@SpringBootTest
@Slf4j
class ApplicationTests {
  private val log = ApplicationTests::class.log

  @Autowired
  private lateinit var amqpTemplate: AmqpTemplate

  // @Autowired
  // private lateinit var stringRedisTemplate: StringRedisTemplate

  @Autowired
  private lateinit var stringHashOps: StringHashOps

  @Test
  fun testAmqp() {
    amqpTemplate.convertAndSend("app.queue", User("admin", "admin"))
  }

  @Test
  fun testRedis() {
    // val opsForHash = stringRedisTemplate.<String, String>opsForHash();
    // opsForHash.delete("hash", 1,2,3,4);
    // opsForHash.get("hash",1);
    stringHashOps.put("hash", "1", "菜")
    val hvalue = stringHashOps["hash", 1]
    log.info { hvalue }
  }

  @Test
  fun webAppCtx() {
    val ctx = webAppCtx
    log.info { ctx.displayName }
  }
}
