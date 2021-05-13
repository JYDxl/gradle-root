package org.github.mongo.dao;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static java.lang.String.valueOf;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@Slf4j
class ITestDaoTest {
    @Autowired
    ITestDao testDao;

    @Test
    void test() {
        val test = new org.github.mongo.model.Test();
        test.setId("1");
        test.setName("test");
        testDao.save(test);
        val one = testDao.findById("1").orElse(null);
        log.info(valueOf(one));
    }
}
