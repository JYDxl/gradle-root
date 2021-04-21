package org.github.cache;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class UsernameCacheTest {
    @Autowired
    private UsernameCache usernameCache;

    @Test
    void getChannel() {
        log.info(usernameCache.getChannel().toString());
    }

    @Test
    void getPrefix() {
        log.info(usernameCache.getPrefix());
    }

    @SuppressWarnings("deprecation")
    @Test
    void key() {
        log.info(usernameCache.key("userId"));
    }

    @SuppressWarnings("deprecation")
    @Test
    void get() {
        log.info(usernameCache.get().toString());
    }

    @Test
    void set() {
        usernameCache.set("userId", "张三");
    }

    @Test
    void del() {
        usernameCache.del("userId");
    }

    @Test
    void getAll() {
        log.info(usernameCache.getAll().toString());
    }

    @SuppressWarnings("deprecation")
    @Test
    void afterPropertiesSet() {
        usernameCache.afterPropertiesSet();
    }

    @Test
    void getRegion() {
        log.info(usernameCache.getRegion());
    }

    @SuppressWarnings("deprecation")
    @Test
    void apply() {
        log.info(usernameCache.apply("userId1"));
    }

    @Test
    void testGet() {
        log.info(usernameCache.get("userId1"));
    }
}
