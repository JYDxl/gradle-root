package org.github.spring.restful.json;

import java.util.Collection;
import java.util.function.Function;

import lombok.*;

import static com.google.common.collect.ImmutableList.toImmutableList;
import static java.util.Collections.emptyList;

/**
 * JSON of array.
 *
 * @param <E> element
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 * @see org.github.spring.restful.json.JSON
 * @see org.github.spring.restful.json.JSONReturn
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JSONArrayReturn<E> extends JSONReturn implements JSON {
  /** data. */
  private @NonNull Collection<? extends E> data = emptyList();

  @Override
  public String toString() {
    return get();
  }

  /** WITH data. */
  public @NonNull JSONArrayReturn<E> withData(@NonNull Collection<? extends E> data) {
    setData(data);
    return this;
  }

  /** Generator. */
  public static <V> @NonNull JSONArrayReturn<V> of() {
    return new JSONArrayReturn<>();
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static <T, R extends T> @NonNull JSONArrayReturn<R> of(@NonNull Collection<T> data) {
    return new JSONArrayReturn(data);
  }

  /** Generator. */
  public static <T, R extends T> @NonNull JSONArrayReturn<R> of(@NonNull Collection<T> data, @NonNull Function<T,R> mapper) {
    return new JSONArrayReturn<>(data.stream().map(mapper).collect(toImmutableList()));
  }
}
