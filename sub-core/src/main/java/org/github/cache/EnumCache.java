package org.github.cache;

import cn.hutool.core.lang.Pair;
import com.google.common.collect.BiMap;
import com.google.common.collect.Table;
import lombok.Data;
import lombok.NonNull;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.commons.lang3.tuple.Triple;
import org.github.base.IEnum;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Map;
import java.util.stream.Stream;

import static cn.hutool.core.util.ClassUtil.getPublicMethod;
import static cn.hutool.core.util.ClassUtil.scanPackageBySuper;
import static cn.hutool.core.util.ReflectUtil.invoke;
import static com.google.common.collect.ImmutableBiMap.copyOf;
import static com.google.common.collect.ImmutableList.toImmutableList;
import static com.google.common.collect.ImmutableTable.toImmutableTable;
import static java.util.Arrays.stream;
import static org.apache.commons.lang3.tuple.Triple.of;

@Slf4j
@Data
public class EnumCache {
  private final @NonNull String packageName;

  private final @NonNull Table<Class<? extends IEnum<?,?>>,?,?> table;

  public EnumCache(@NonNull String packageName) {
    this.packageName = packageName;
    this.table       = load(packageName);
  }

  private Table<Class<? extends IEnum<?,?>>,?,?> load(String packageName) {
    val classes = scanPackageBySuper(packageName, IEnum.class);
    return classes.stream().flatMap(this::apply).collect(toImmutableTable(Triple::getLeft, Triple::getMiddle, Triple::getRight));
  }

  @SuppressWarnings("unchecked")
  private Stream<Triple<Class<? extends IEnum<?,?>>,?,?>> apply(Class<?> clazz) {
    if (!clazz.isEnum()) throw new IllegalStateException();
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
  public <C, V, E extends Class<? extends IEnum<C,V>>> @NonNull BiMap<C,V> getAll(@NonNull E clazz) {
    return (BiMap<C,V>) copyOf(table.row(clazz));
  }

  @SuppressWarnings("unchecked")
  public <C, V, E extends Class<? extends IEnum<C, V>>> @NonNull List<Pair<C, V>> getList(@NonNull E clazz) {
    return ((Map<C, V>) table.row(clazz)).entrySet().stream().map(v -> new Pair<>(v.getKey(), v.getValue())).collect(toImmutableList());
  }
}
