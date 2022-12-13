package org.github.core.spring.restful.json;

import com.google.common.collect.ImmutableList;
import io.swagger.annotations.ApiModelProperty;
import java.util.Collection;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.github.core.base.IPage;

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
public class JSONPageReturn<E> extends JSONArrayReturn<E> implements JSON {
  @ApiModelProperty("总数")
  private long total = 0L;

  @Override
  public String toString() {
    return get();
  }

  /** WITH total. */
  @NonNull
  public JSONPageReturn<E> withTotal(long total) {
    setTotal(total);
    return this;
  }

  /** Generator. */
  @NonNull
  public static <V> JSONPageReturn<V> of() {
    return new JSONPageReturn<>();
  }

  /** Generator. */
  @NonNull
  public static <T, R extends T> JSONPageReturn<R> of(@NonNull IPage<T> page) {
    return of(page.getTotal(), page.getRecords());
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @NonNull
  public static <T, R extends T> JSONPageReturn<R> of(long total, @NonNull Collection<T> data) {
    return (JSONPageReturn) new JSONPageReturn<>(total).withData(data);
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @NonNull
  public static <T, R extends T> JSONPageReturn<R> of(@NonNull IPage<T> page, @NonNull Function<T,R> mapper) {
    return (JSONPageReturn) new JSONPageReturn<>(page.getTotal()).withData(page.getRecords().stream().map(mapper).collect(ImmutableList.toImmutableList()));
  }

  /** Generator. */
  @NonNull
  public static <T, R extends T> JSONPageReturn<R> of(@NonNull IPage<T> page, @NonNull Collection<R> data) {
    return of(page.getTotal(), data);
  }
}
