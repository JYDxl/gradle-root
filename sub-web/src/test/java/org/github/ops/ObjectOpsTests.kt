package org.github.ops

import org.github.base.entity.TipLoginLogEntity
import org.github.base.service.ITipLoginLogService
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@ActiveProfiles("test")
@SpringBootTest
class ObjectOpsTests {
  @Autowired
  private lateinit var tipLoginLogService: ITipLoginLogService

  @Test
  fun json() {
    val list: MutableList<TipLoginLogEntity> = tipLoginLogService.list()
    log.info(list.json())
  }
}

private val log = LoggerFactory.getLogger(ObjectOpsTests::class.java)!!
