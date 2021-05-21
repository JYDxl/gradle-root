package org.github.cache;

import lombok.extern.slf4j.*;
import lombok.*;
import org.github.mysql.web.base.enums.Sex;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class EnumCacheTest {
  @Autowired
  EnumCache enumCache;

  @Test
  void getAllTest() {
    val map = enumCache.getAll(Sex.class);
    log.info(map.toString());
  }

  @Test
  void getTest() {
    val value1 = enumCache.get(Sex.class, 0);
    log.info(value1);
    val value2 = enumCache.get(Sex.class, 2);
    log.info(value2);
  }

  @Test
  void test() {
    log.info(enumCache.toString());
    val packageName = enumCache.getPackageName();
    log.info(packageName);
    val table = enumCache.getTable();
    log.info(table.toString());
  }
}
