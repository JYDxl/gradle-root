package org.github.cache;

import java.util.Map;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import lombok.*;
import lombok.extern.slf4j.*;
import org.github.base.IEnum;
import org.apache.commons.lang3.tuple.Triple;
import com.google.common.collect.Table;
import static cn.hutool.core.util.ClassUtil.getPublicMethod;
import static cn.hutool.core.util.ClassUtil.*;
import static cn.hutool.core.util.ReflectUtil.invoke;
import static com.google.common.collect.ImmutableTable.*;
import static java.util.Arrays.*;
import static java.util.stream.Stream.*;
import static org.apache.commons.lang3.tuple.Triple.of;

@Slf4j
@Data
public class EnumCache {
  @NonNull
  private final String packageName;

  @NonNull
  private final Table<Class<? extends IEnum<?,?>>,?,?> table;

  public EnumCache(@NonNull String packageName) {
    this.packageName = packageName;
    this.table = load(packageName);
  }

  private Table<Class<? extends IEnum<?,?>>,?,?> load(String packageName) {
    val classes = scanPackageBySuper(packageName, IEnum.class);
    return classes.stream().flatMap(this::apply).collect(toImmutableTable(Triple::getLeft, Triple::getMiddle, Triple::getRight));
  }

  @SuppressWarnings("unchecked")
  private Stream<Triple<Class<? extends IEnum<?,?>>,?,?>> apply(Class<?> clazz) {
    if (!clazz.isEnum()) return empty();
    val method = getPublicMethod(clazz, "values");
    val values = ((IEnum<?,?>[]) invoke(null, method));
    val token  = ((Class<? extends IEnum<?,?>>) clazz);
    return stream(values).map(v -> of(token, v.getCode(), v.getValue()));
  }

  @SuppressWarnings("unchecked")
  public @Nullable <C, V, E extends Class<? extends IEnum<C,V>>> V get(@NonNull E clazz, @Nullable C code) {
    if (code == null) return null;
    val value = table.get(clazz, code);
    if (value == null) log.warn("在常量枚举[{}]中发现了未知的类型编码: {}", clazz, code);
    return (V) value;
  }

  @SuppressWarnings("unchecked")
  public @NonNull <C, V, E extends Class<? extends IEnum<C,V>>> Map<C,V> getAll(@NonNull E clazz) {
    return (Map<C,V>) table.row(clazz);
  }
}
