package org.github.util;

import java.util.Objects;
import java.util.function.Predicate;
import cn.hutool.core.util.StrUtil;

public abstract class ObjUtil {
  @SafeVarargs
  public static <T> T firstNonNull(T... objs) {
    return firstOne(Objects::nonNull, objs);
  }

  @SafeVarargs
  public static <T> T firstOne(Predicate<T> predicate, T... objs) {
    for (T obj : objs) {
      if (predicate.test(obj)) {
        return obj;
      }
    }
    throw new IllegalArgumentException("All parameters are mismatch");
  }

  public static CharSequence firstNonBlank(CharSequence... objs) {
    return firstOne(StrUtil::isNotBlank, objs);
  }
}