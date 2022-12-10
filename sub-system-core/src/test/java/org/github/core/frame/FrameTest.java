package org.github.core.frame;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

@Slf4j
public class FrameTest {
  @Test
  void test0() {
    test1();
  }

  void test1() {
    log.info("test0");
    test2();
  }

  void test2() {
    log.info("test1");
    test3();
  }

  void test3() {
    log.info("test2");
    log.info("Hello world!");
  }
}
