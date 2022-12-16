package org.github.core.spring.restful.json;

import io.swagger.annotations.ApiModelProperty;
import java.util.Collection;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.github.core.base.IPage;
import static com.google.common.collect.ImmutableList.toImmutableList;

/**
 * JSON of page.
 *
 * @param <E> element
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JSONPage<E> extends JSONArray<E> implements JSON {
  @ApiModelProperty("总数")
  private long total = 0L;

  @Override
  public String toString() {
    return get();
  }

  /** WITH total. */
  @NotNull
  public JSONPage<E> withTotal(long total) {
    setTotal(total);
    return this;
  }

  /** Generator. */
  @NotNull
  public static <V> JSONPage<V> of() {
    return new JSONPage<>();
  }

  /** Generator. */
  @NotNull
  public static <T, R extends T> JSONPage<R> of(@NotNull IPage<T> page) {
    return of(page.getTotal(), page.getRecords());
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @NotNull
  public static <T, R extends T> JSONPage<R> of(long total, @NotNull Collection<T> data) {
    return (JSONPage) new JSONPage<>(total).withData(data);
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @NotNull
  public static <T, R extends T> JSONPage<R> of(@NotNull IPage<T> page, @NotNull Function<T,R> mapper) {
    return (JSONPage) new JSONPage<>(page.getTotal()).withData(page.getRecords().stream().map(mapper).collect(toImmutableList()));
  }

  /** Generator. */
  @NotNull
  public static <T, R extends T> JSONPage<R> of(@NotNull IPage<T> page, @NotNull Collection<R> data) {
    return of(page.getTotal(), data);
  }
}
