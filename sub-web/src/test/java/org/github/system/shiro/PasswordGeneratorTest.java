package org.github.system.shiro;

import lombok.extern.slf4j.*;
import org.github.shiro.PasswordGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.github.mysql.mydb.base.dict.DictKt.DEFAULT_VALUE_INITIAL_PASSWORD;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class PasswordGeneratorTest {
  @Autowired
  private PasswordGenerator generator;

  @Test
  void generator() {
    log.info(generator.generate(DEFAULT_VALUE_INITIAL_PASSWORD, "anonymous"));
    log.info(generator.generate(DEFAULT_VALUE_INITIAL_PASSWORD, "admin"));
    log.info(generator.generate(DEFAULT_VALUE_INITIAL_PASSWORD, "l"));
    log.info(generator.generate(DEFAULT_VALUE_INITIAL_PASSWORD, "guest"));
    log.info(generator.generate(DEFAULT_VALUE_INITIAL_PASSWORD, "test"));
  }
}
