package org.github;

import java.time.LocalDateTime;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.github.base.entity.TipLoginLogEntity;
import org.github.base.service.ITipLoginLogService;
import org.github.base.service.ITipOptLogService;
import org.github.common.mapper.CommonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.junit4.SpringRunner;
import com.baomidou.mybatisplus.core.toolkit.Wrappers;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@ActiveProfiles("test")
@Slf4j
public class ApplicationTests {
  @Autowired
  private CommonMapper commonMapper;

  @Autowired
  private ObjectMapper objectMapper;

  @Autowired
  private ITipLoginLogService tipLoginLogService;

  @Autowired
  private ApplicationContext applicationContext;

  @Autowired
  private ITipOptLogService tipOptLogService;

  @Test
  public void contextLoads() throws JsonProcessingException {
    val env   = applicationContext.getEnvironment();
    val now   = commonMapper.now();
    val query = Wrappers.<TipLoginLogEntity>lambdaQuery();
    query
      .eq(TipLoginLogEntity::getLogUser, "hanjian")
      .le(TipLoginLogEntity::getLogTime, LocalDateTime.now());
    val page = tipLoginLogService.page(new Page<>(2, 10), query);
    log.info(objectMapper.writeValueAsString(now));
    log.info(String.valueOf(page.getTotal()));
    log.info(env.getProperty("os.name"));
  }

  @Test
  public void page() throws JsonProcessingException {
    val page = commonMapper.page(new Page());
    log.info(objectMapper.writeValueAsString(page));
  }
}
