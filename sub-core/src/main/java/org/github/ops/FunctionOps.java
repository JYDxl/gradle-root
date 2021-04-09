package org.github.ops;

import java.util.ConcurrentModificationException;
import java.util.function.BinaryOperator;

public abstract class FunctionOps {
  public static <T> BinaryOperator<T> ignore() {
    return (t1, t2) -> { throw new ConcurrentModificationException();};
  }
}
