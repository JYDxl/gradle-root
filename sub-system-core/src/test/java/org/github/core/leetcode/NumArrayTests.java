package org.github.core.leetcode;

import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import static java.lang.String.valueOf;

@Slf4j
public class NumArrayTests {
  @Test
  public void test() {
    NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
    log.info(valueOf(numArray.sumRange(0, 2)));
    log.info(valueOf(numArray.sumRange(2, 5)));
    log.info(valueOf(numArray.sumRange(0, 5)));
  }

  @Test
  public void testMove() {
//    val num1 = 15;
//    log.info(toBinaryString(num1));
//    val num2 = num1 >> 3;
//    log.info(valueOf(num2));
//    log.info(toBinaryString(num2));
//    log.info(toBinaryString(15 & ((1 << 3) - 1)));
//    log.info(valueOf(15 & ((1 << 3) - 1)));
    log.info(valueOf(((1 << 1) - 1)));
  }
}
