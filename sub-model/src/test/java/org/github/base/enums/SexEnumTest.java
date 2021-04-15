package org.github.base.enums;

import lombok.extern.slf4j.*;
import lombok.*;
import org.junit.jupiter.api.Test;
import static org.github.ops.Functions.*;

@Slf4j
class SexEnumTest {
  @Test
  void testAsMap() {
    val map = SexEnum.values()[0].asMap();
    log.info(map(null, map));
    log.info(map(0, map));
    log.info(map(1, map));
    log.info(map(2, map));
  }

  @Test
  void testTurn() {
    log.info(SexEnum.values()[0].turn(null));
    log.info(SexEnum.values()[0].turn(0));
    log.info(SexEnum.values()[0].turn(1));
    log.info(SexEnum.values()[0].turn(2));
  }
}
