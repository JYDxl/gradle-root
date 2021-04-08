package org.github.spring.restful.json;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Function;
import lombok.*;
import static org.github.spring.footstone.IConstKt.*;

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
  @NonNull
  private Object[] data = getArray();

  @Override
  public String toString() {
    return get();
  }

  /** GET data. */
  @SuppressWarnings("unchecked")
  @NonNull
  public E[] toArray() {
    return (E[]) data;
  }

  /** GET data. */
  @SuppressWarnings("unchecked")
  @NonNull
  public List<E> toList() {
    return (List<E>) Arrays.asList(data);
  }

  /** WITH data. */
  @SafeVarargs
  @NonNull
  public final JSONArrayReturn<E> withData(E... data) {
    setData(data);
    return this;
  }

  /** WITH data. */
  @NonNull
  public JSONArrayReturn<E> withData(@NonNull Collection<? extends E> data) {
    setData(data.toArray());
    return this;
  }

  /** Generator. */
  @NonNull
  public static JSONArrayReturn<?> of() {
    return new JSONArrayReturn<>();
  }

  /** Generator. */
  @SafeVarargs
  @NonNull
  public static <V> JSONArrayReturn<V> of(V... data) {
    return new JSONArrayReturn<>(data);
  }

  /** Generator. */
  @NonNull
  public static <V> JSONArrayReturn<V> of(@NonNull Collection<V> data) {
    return new JSONArrayReturn<>(data.toArray());
  }

  /** Generator. */
  @NonNull
  public static <T, R> JSONArrayReturn<R> of(@NonNull Collection<T> data, @NonNull Function<T,R> mapper) {
    return new JSONArrayReturn<>(data.stream().map(mapper).toArray());
  }
}
