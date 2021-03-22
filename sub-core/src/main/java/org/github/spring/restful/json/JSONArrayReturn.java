package org.github.spring.restful.json;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nonnull;

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
 * @see JSONReturn
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JSONArrayReturn<E> extends JSONReturn implements JSON {
  /** data. */
  @NonNull
  private Object[] data = getArray();

  /** GET data. */
  @SuppressWarnings("unchecked")
  @Nonnull
  public E[] toArray() {
    return (E[]) data;
  }

  /** GET data. */
  @SuppressWarnings("unchecked")
  @Nonnull
  public List<E> toList() {
    return (List<E>) Arrays.asList(data);
  }

  /** WITH data. */
  @SafeVarargs
  @Nonnull
  public final JSONArrayReturn<E> withData(E... data) {
    setData(data);
    return this;
  }

  /** WITH data. */
  @Nonnull
  public JSONArrayReturn<E> withData(@Nonnull Collection<? extends E> data) {
    setData(data.toArray());
    return this;
  }

  /** Generator. */
  @Nonnull
  public static JSONArrayReturn<?> of() {
    return new JSONArrayReturn<>();
  }

  /** Generator. */
  @SafeVarargs
  @Nonnull
  public static <V> JSONArrayReturn<V> of(V... data) {
    return new JSONArrayReturn<>(data);
  }

  /** Generator. */
  @Nonnull
  public static <V> JSONArrayReturn<V> of(@Nonnull Collection<? extends V> data) {
    return new JSONArrayReturn<>(data.toArray());
  }
}
