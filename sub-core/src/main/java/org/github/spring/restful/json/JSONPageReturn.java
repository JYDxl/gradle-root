package org.github.spring.restful.json;

import lombok.*;
import org.github.base.IPage;

import java.util.List;
import java.util.function.Function;

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
  /** total. */
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
  public static <V> JSONPageReturn<V> emptyPage() {
    return new JSONPageReturn<>();
  }

  /** Generator. */
  @NonNull
  public static <V> JSONPageReturn<V> of(@NonNull IPage<V> page) {
    return of(page.getTotal(), page.getRecords());
  }

  /** Generator. */
  @NonNull
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static <V> JSONPageReturn<V> of(long total, @NonNull List<V> data) {
    return (JSONPageReturn) new JSONPageReturn<>(total).withData(data);
  }

  /** Generator. */
  @NonNull
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static <T, R> JSONPageReturn<R> of(@NonNull IPage<T> page, @NonNull Function<T,R> mapper) {
    return (JSONPageReturn) new JSONPageReturn<>(page.getTotal()).withData(page.getRecords().stream().map(mapper).toArray());
  }
}
