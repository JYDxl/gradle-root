package org.github.ops;

public class Bits {
  public int lastN(int num, int n) {
    return num & ((1 << 3) - 1);
  }

  public long lastN(long num, int n) {
    return num & ((1 << 3) - 1);
  }
}
