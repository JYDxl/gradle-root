package org.github.core.util;

import java.util.Collection;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Stream;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import static java.util.Optional.ofNullable;

public abstract class FuncUtil {
  public static <T> BinaryOperator<T> throwing() {
    return (t1, t2) -> {throw new UnsupportedOperationException();};
  }

  public static <T, R> Function<T,Optional<R>> optional(@NotNull Function<T,R> function) {
    return (t) -> ofNullable(t).map(function);
  }

  public static <T, R> Function<T,R> optional(@NotNull Function<T,R> function, @Nullable R defaultValue) {
    return (t) -> ofNullable(t).map(function).orElse(defaultValue);
  }

  public static <T, R> R map(@Nullable T t, @NotNull Map<T,R> map) {
    return map(t, map, null);
  }

  public static <T, R> R map(@Nullable T t, @NotNull Map<T,R> map, @Nullable R defaultValue) {
    return ofNullable(t).map(map::get).orElse(defaultValue);
  }

  public static <T> Stream<T> stream(@Nullable Collection<T> collection) {
    return collection == null || collection.isEmpty() ? Stream.empty() : collection.stream();
  }

  public static <T> Predicate<T> pass() {
    return v -> true;
  }

  public static <T> Predicate<T> noPass() {
    return v -> false;
  }

  public static <T> Predicate<T> nonNull() {
    return Objects::nonNull;
  }
}
