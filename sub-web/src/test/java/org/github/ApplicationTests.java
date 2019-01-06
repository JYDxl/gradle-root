package org.github;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.github.base.entity.TipLoginLogEntity;
import org.github.base.mapper.TipLoginLogMapper;
import org.github.common.mapper.CommonMapper;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
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
  private TipLoginLogMapper tipLoginLogMapper;

  @Test
  public void contextLoads() throws JsonProcessingException {
    val now   = commonMapper.now();
    val query = Wrappers.<TipLoginLogEntity>lambdaQuery();
    query.eq(TipLoginLogEntity::getLogUser, "hanjian");
    val page = tipLoginLogMapper.selectPage(new Page<>(), query);
    log.debug(objectMapper.writeValueAsString(now));
    log.debug(objectMapper.writeValueAsString(page));
  }
}
