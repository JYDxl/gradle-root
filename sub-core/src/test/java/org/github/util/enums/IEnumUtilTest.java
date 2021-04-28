package org.github.util.enums;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.junit.jupiter.api.Test;

import static org.github.util.enums.IEnumUtil.load;

@Slf4j
class IEnumUtilTest {
    @Test
    void loadTest() {
        val packageName = "org.github";
        val table = load(packageName);
        log.info(table.toString());
    }
}
