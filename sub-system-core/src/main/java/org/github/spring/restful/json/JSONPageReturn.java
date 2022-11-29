package org.github.spring.restful.json;

import java.util.Collection;
import java.util.function.Function;
import lombok.*;
import org.github.base.IPage;
import static com.google.common.collect.ImmutableList.*;

/**
 * JSON of page.
 *
 * @param <E> element
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 * @see org.github.spring.restful.json.JSON
 * @see org.github.spring.restful.json.JSONReturn
 * @see org.github.spring.restful.json.JSONArrayReturn
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JSONPageReturn<E> extends JSONArrayReturn<E> implements JSON {
  /** 总数 */
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
    return (JSONPageReturn) new JSONPageReturn<>(page.getTotal()).withData(page.getRecords().stream().map(mapper).collect(toImmutableList()));
  }

  /** Generator. */
  @NonNull
  public static <T, R extends T> JSONPageReturn<R> of(@NonNull IPage<T> page, @NonNull Collection<R> data) {
    return of(page.getTotal(), data);
  }
}
