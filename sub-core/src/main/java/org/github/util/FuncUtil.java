package org.github.util;

import java.util.Collection;
import java.util.Map;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import lombok.*;
import static java.util.Optional.*;

public abstract class FuncUtil {
  public static <T> BinaryOperator<T> throwing() {
    return (t1, t2) -> {throw new UnsupportedOperationException();};
  }

  public static <T, R> Function<T,Optional<R>> optional(@NonNull Function<T,R> function) {
    return (t) -> ofNullable(t).map(function);
  }

  public static <T, R> Function<T,R> optional(@NonNull Function<T,R> function, @Nullable R defaultValue) {
    return (t) -> ofNullable(t).map(function).orElse(defaultValue);
  }

  public static <T, R> R map(@Nullable T t, @NonNull Map<T,R> map) {
    return map(t, map, null);
  }

  public static <T, R> R map(@Nullable T t, @NonNull Map<T,R> map, @Nullable R defaultValue) {
    return ofNullable(t).map(map::get).orElse(defaultValue);
  }

  public static <T> Stream<T> stream(@Nullable Collection<T> collection) {
    return collection == null || collection.isEmpty() ? Stream.empty() : collection.stream();
  }

  public static <T> Predicate<T> pass() {
    return v -> true;
  }
}
