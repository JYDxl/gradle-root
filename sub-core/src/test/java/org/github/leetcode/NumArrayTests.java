package org.github.leetcode;

import lombok.extern.slf4j.*;
import org.junit.jupiter.api.Test;

@Slf4j
public class NumArrayTests {
  @Test
  public void test() {
    NumArray numArray = new NumArray(new int[]{-2, 0, 3, -5, 2, -1});
    log.info(String.valueOf(numArray.sumRange(0, 2)));
    log.info(String.valueOf(numArray.sumRange(2, 5)));
    log.info(String.valueOf(numArray.sumRange(0, 5)));
  }
}
