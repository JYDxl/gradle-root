package org.github.core.cache;

import cn.hutool.core.lang.Pair;
import com.google.common.collect.Table;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;
import javax.annotation.Nullable;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.tuple.Triple;
import org.github.core.base.IEnum;
import static cn.hutool.core.util.ClassUtil.scanPackageBySuper;
import static cn.hutool.core.util.ReflectUtil.getMethod;
import static cn.hutool.core.util.ReflectUtil.invokeStatic;
import static com.google.common.collect.ImmutableBiMap.copyOf;
import static com.google.common.collect.ImmutableList.toImmutableList;
import static com.google.common.collect.ImmutableTable.toImmutableTable;
import static java.util.Arrays.stream;
import static org.apache.commons.lang3.tuple.Triple.of;

@Slf4j
@Data
public class EnumCache {
  private final @NonNull String packageName;

  private final @NonNull Table<String,?,?> table;

  public EnumCache(@NonNull String packageName) {
    this.packageName = packageName;
    this.table       = load(packageName);
  }

  private Table<String,?,?> load(String packageName) {
    val classes = scanPackageBySuper(packageName, IEnum.class);
    return classes.stream().flatMap(this::apply).collect(toImmutableTable(Triple::getLeft, Triple::getMiddle, Triple::getRight));
  }

  private Stream<Triple<String,?,?>> apply(Class<?> clazz) {
    if (clazz.isInterface()) return Stream.of();
    if (!clazz.isEnum()) throw new IllegalStateException();
    val method = getMethod(clazz, "values");
    val values = ((IEnum<?,?>[]) invokeStatic(method));
    val token  = clazz.getSimpleName();
    return stream(values).map(v -> of(token, v.getCode(), v.getValue()));
  }

  @SuppressWarnings("unchecked")
  public @Nullable <C, V> V get(@NonNull String type, @Nullable C code) {
    if (code == null) return null;
    val value = table.get(type, code);
    if (value == null) log.warn("在常量枚举[{}]中发现了未知的类型编码: {}", type, code);
    return (V) value;
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public <C, V> Map<C,V> getAll(@NonNull String type) {
    return (Map<C,V>) copyOf(table.row(type));
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public <C, V> List<Pair<C,V>> getList(@NonNull String type) {
    return ((Map<C,V>) table.row(type)).entrySet().stream().map(v -> new Pair<>(v.getKey(), v.getValue())).collect(toImmutableList());
  }
}
