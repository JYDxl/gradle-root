package org.github.core.leetcode;

// import java.util.Arrays;
// import java.util.stream.Stream;

public class NumArray {
  private final int[] ary;

  public NumArray(int[] nums) {
    // ary = nums;

    ary = new int[nums.length + 1];
    for (int i = 1; i <= nums.length; i++) {
      ary[i] = ary[i - 1] + nums[i - 1];
    }
  }

  public int sumRange(int i, int j) {
    // int sum = 0;
    // for(int k = i; k <= j; k++) {
    //   sum += ary[k];
    // }
    // return sum;

    // return Arrays.stream(ary).skip(i).limit(j-i+1).sum();

    return ary[j + 1] - ary[i];
  }
}
