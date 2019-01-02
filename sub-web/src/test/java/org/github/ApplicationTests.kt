package org.github

import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import com.fasterxml.jackson.databind.ObjectMapper
import org.github.base.entity.TipLoginLogEntity
import org.github.base.mapper.TipLoginLogMapper
import org.github.common.mapper.CommonMapper
import org.junit.Test
import org.junit.runner.RunWith
import org.slf4j.LoggerFactory
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@SpringBootTest
class ApplicationTests {
  @Autowired
  private lateinit var commonMapper: CommonMapper
  @Autowired
  private lateinit var objectMapper: ObjectMapper
  @Autowired
  private lateinit var tipLoginLogMapper: TipLoginLogMapper

  @Test
  fun contextLoads() {
    val now = commonMapper.now()
    val page: IPage<TipLoginLogEntity> = tipLoginLogMapper.selectPage(Page(), null)
    log.debug(objectMapper.writeValueAsString(now))
    log.debug(objectMapper.writeValueAsString(page))
  }
}

private val log = LoggerFactory.getLogger(ApplicationTests::class.java)!!
