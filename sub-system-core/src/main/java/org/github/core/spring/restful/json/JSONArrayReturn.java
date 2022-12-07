package org.github.core.spring.restful.json;

import lombok.*;

import java.util.Collection;
import java.util.function.Function;

import static com.google.common.collect.ImmutableList.toImmutableList;
import static java.util.Collections.emptyList;

/**
 * JSON of array.
 *
 * @param <E> element
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.core.spring.restful.Returnable
 * @see org.github.core.spring.restful.json.JSON
 * @see org.github.core.spring.restful.json.JSONReturn
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JSONArrayReturn<E> extends JSONReturn implements JSON {
  /** 数据 */
  private @NonNull Collection<? extends E> data = emptyList();

  @Override
  public String toString() {
    return get();
  }

  @NonNull
  public Collection<? extends E> getData() {
    return data;
  }

  /** WITH data. */
  @NonNull
  public JSONArrayReturn<E> withData(@NonNull Collection<? extends E> data) {
    setData(data);
    return this;
  }

  /** Generator. */
  @NonNull
  public static <V> JSONArrayReturn<V> of() {
    return new JSONArrayReturn<>();
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @NonNull
  public static <T, R extends T> JSONArrayReturn<R> of(@NonNull Collection<T> data) {
    return new JSONArrayReturn(data);
  }

  /** Generator. */
  @NonNull
  public static <T, R extends T> JSONArrayReturn<R> of(@NonNull Collection<T> data, @NonNull Function<T,R> mapper) {
    return new JSONArrayReturn<>(data.stream().map(mapper).collect(toImmutableList()));
  }
}
