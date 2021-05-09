package org.github.cache;

import lombok.*;
import lombok.extern.slf4j.*;
import org.github.base.entity.UserEntity;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.github.web.common.CacheNameEnum.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class RAMCacheTest {
  @Autowired
  RAMCache ramCache;

  @Test
  void getCache() {
    val userCache = ramCache.<UserEntity>getCache(user);
    val userMap   = userCache.getAll();
    log.info(userMap.toString());
    log.info(userCache.toString());
    try {
      ramCache.<String>getCache(username);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }
}
