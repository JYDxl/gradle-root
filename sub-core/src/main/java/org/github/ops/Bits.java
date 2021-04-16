package org.github.ops;

public abstract class Bits {
  public static int lastN(int num, int n) {
    return num & ((1 << n) - 1);
  }

  public static long lastN(long num, int n) {
    return num & ((1L << n) - 1);
  }
}
