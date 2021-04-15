package org.github.ops;

import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import lombok.*;
import static java.util.Optional.*;

public abstract class Functions {
  public static <T> BinaryOperator<T> throwing() {
    return (t1, t2) -> {throw new UnsupportedOperationException();};
  }

  public static <T, R> Function<T,Optional<R>> optional(@NonNull Function<T,R> function) {
    return (t) -> ofNullable(t).map(function);
  }

  public static <T, R> Function<T,R> optional(@NonNull Function<T,R> function, R defaultValue) {
    return (t) -> ofNullable(t).map(function).orElse(defaultValue);
  }

  public static <T, R> R map(T t, @NonNull Map<T,R> map) {
    return map(t, map, null);
  }

  public static <T, R> R map(T t, @NonNull Map<T,R> map, R defaultValue) {
    return ofNullable(t).map(map::get).orElse(defaultValue);
  }
}
