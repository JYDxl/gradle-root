package org.github.system.shiro;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.github.shiro.PasswordGenerator;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static cn.hutool.core.lang.UUID.fastUUID;
import static org.github.shiro.ops.ShiroKt.DEFAULT_VALUE_INITIAL_PASSWORD;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class PasswordGeneratorTest {
  @Autowired
  private PasswordGenerator generator;

  @Test
  void generator() {
    val anonymous = fastUUID().toString();
    log.info("password:{} salt:{}", generator.generate(DEFAULT_VALUE_INITIAL_PASSWORD, anonymous), anonymous);
    val admin = fastUUID().toString();
    log.info("password:{} salt:{}", generator.generate(DEFAULT_VALUE_INITIAL_PASSWORD, admin), admin);
    val l = fastUUID().toString();
    log.info("password:{} salt:{}", generator.generate(DEFAULT_VALUE_INITIAL_PASSWORD, l), l);
    val guest = fastUUID().toString();
    log.info("password:{} salt:{}", generator.generate(DEFAULT_VALUE_INITIAL_PASSWORD, guest), guest);
    val test = fastUUID().toString();
    log.info("password:{} salt:{}", generator.generate(DEFAULT_VALUE_INITIAL_PASSWORD, test), test);
  }
}
