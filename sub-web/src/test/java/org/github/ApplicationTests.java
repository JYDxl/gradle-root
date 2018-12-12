package org.github;

import lombok.extern.slf4j.Slf4j;
import lombok.val;

import org.github.common.mapper.CommonMapper;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

@RunWith(SpringRunner.class)
@SpringBootTest
@Slf4j
public class ApplicationTests {
  @Autowired
  private CommonMapper commonMapper;
  @Autowired
  private ObjectMapper objectMapper;

  @Test
  public void contextLoads() throws JsonProcessingException {
    val now   = commonMapper.getNow();
    val value = objectMapper.writeValueAsString(now);
    log.debug(value);
  }
}
