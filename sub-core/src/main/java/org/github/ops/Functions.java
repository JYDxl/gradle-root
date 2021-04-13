package org.github.ops;

import java.util.ConcurrentModificationException;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import lombok.*;
import static java.util.Optional.*;

public abstract class Functions {
  public static <T> BinaryOperator<T> throwing() {
    return (t1, t2) -> { throw new ConcurrentModificationException();};
  }

  public static <T, R> Function<T,Optional<R>> optional(@NonNull Function<T,R> function) {
    return (t) -> ofNullable(t).map(function);
  }

  public static <T, R> Function<T,R> optional(@NonNull Function<T,R> function, R defaultValue) {
    return (t) -> ofNullable(t).map(function).orElse(defaultValue);
  }
}
