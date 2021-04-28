package org.github.cache;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.github.base.enums.SexEnum;
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
    void getTest() {
        val value1 = enumCache.get(SexEnum.class, 0);
        log.info(value1);
        val value2 = enumCache.get(SexEnum.class, 2);
        log.info(value2);
    }

    @Test
    void getAllTest() {
        val map = enumCache.getAll(SexEnum.class);
        log.info(map.toString());
    }
}
