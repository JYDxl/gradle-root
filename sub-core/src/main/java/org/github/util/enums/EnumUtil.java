package org.github.util.enums;

import java.util.stream.Stream;
import lombok.*;
import org.github.base.IEnum;
import org.apache.commons.lang3.tuple.Triple;
import com.google.common.collect.Table;
import static cn.hutool.core.util.ClassUtil.*;
import static com.google.common.collect.ImmutableTable.*;
import static com.google.common.reflect.Invokable.*;
import static java.util.Arrays.*;
import static java.util.stream.Stream.*;
import static org.apache.commons.lang3.tuple.Triple.of;

public abstract class EnumUtil {
  public static @NonNull Table<Class<?>,?,?> load(@NonNull String packageName) {
    val classes = scanPackageBySuper(packageName, IEnum.class);
    return classes.stream().flatMap(EnumUtil::apply).collect(toImmutableTable(Triple::getLeft, Triple::getMiddle, Triple::getRight));
  }

  @SneakyThrows
  private static Stream<Triple<Class<?>,?,?>> apply(Class<?> clazz) {
    if (!clazz.isEnum()) return empty();
    val method    = clazz.getMethod("values");
    val invokable = from(method);
    val values    = ((IEnum<?,?>[]) invokable.invoke(null));
    return stream(values).map(v -> of(clazz, v.getCode(), v.getValue()));
  }
}
