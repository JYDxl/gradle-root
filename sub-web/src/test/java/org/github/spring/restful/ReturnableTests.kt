package org.github.spring.restful

import com.baomidou.mybatisplus.core.metadata.IPage
import com.baomidou.mybatisplus.extension.plugins.pagination.Page
import org.github.base.entity.TipLoginLogEntity
import org.github.base.service.ITipLoginLogService
import org.github.ops.json
import org.github.ops.log
import org.github.spring.restful.json.JSONPage
import org.junit.Test
import org.junit.runner.RunWith
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.context.SpringBootTest
import org.springframework.test.context.ActiveProfiles
import org.springframework.test.context.junit4.SpringRunner

@RunWith(SpringRunner::class)
@ActiveProfiles("dev")
@SpringBootTest
class ReturnableTests {
  /** log. */
  private val log = ReturnableTests::class.log
  @Autowired
  private lateinit var tipLoginLogService: ITipLoginLogService

  @Test
  fun testJSONPage() {
    val page: IPage<TipLoginLogEntity> = tipLoginLogService.page(Page())
    val result: JSONPage<TipLoginLogEntity> = JSONPage.of(page)
    log.info(result.json)
  }
}
