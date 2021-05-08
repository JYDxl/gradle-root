package org.github.system.shiro;

import lombok.extern.slf4j.*;
import lombok.*;
import org.github.shiro.PasswordGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class PasswordGeneratorTest {
  @Autowired
  private PasswordGenerator generator;

  @Test
  void generator() {
    val result = generator.generate("123456", "jack");
    log.info(result);
  }
}
