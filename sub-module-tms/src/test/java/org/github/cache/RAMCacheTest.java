package org.github.cache;

import lombok.*;
import lombok.extern.slf4j.*;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import static org.github.web.common.CacheName.*;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class RAMCacheTest {
  @Autowired
  RAMCache ramCache;

  @Test
  void getCache() {
    val sysMenuNameCache = ramCache.<String>getCache(SYS_MENU_NAME);
    val sysMenuNameList  = sysMenuNameCache.getAll();
    log.info(sysMenuNameList.toString());
    log.info(sysMenuNameCache.toString());
    try {
      ramCache.<String>getCache(USERNAME);
    } catch (Exception e) {
      log.error(e.getMessage(), e);
    }
  }
}
