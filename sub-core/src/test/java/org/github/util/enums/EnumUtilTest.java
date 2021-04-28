package org.github.util.enums;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;

import java.io.IOException;

import static org.github.util.enums.EnumUtil.load;

@Slf4j
class EnumUtilTest {
  @Test
  void loadTest() throws IOException {
    val packageName = "org.github.base.enums";
    val table       = load(packageName);
    log.info(table.toString());
  }
}
