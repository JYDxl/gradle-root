package org.github.spring.restful.json;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.github.spring.footstone.IConstKt;

/**
 * JSON of array.
 *
 * @param <E> element
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 * @see org.github.spring.restful.json.JSON
 * @see org.github.spring.restful.json.JSONBasic
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JSONArray<E> extends JSONBasic implements JSON {
  /** data. */
  @NonNull
  private Object[] data = IConstKt.getArray();

  @Override
  public void release() {
    data = IConstKt.getArray();
    super.release();
  }

  @Override
  public String toString() {
    return get();
  }

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
  public final JSONArray<E> withData(E... data) {
    setData(data);
    return this;
  }

  /** WITH data. */
  @Nonnull
  public JSONArray<E> withData(@Nonnull Collection<? extends E> data) {
    setData(data.toArray());
    return this;
  }

  /** Generator. */
  @Nonnull
  public static JSONArray of() {
    return new JSONArray();
  }

  /** Generator. */
  @SafeVarargs
  @Nonnull
  public static <V> JSONArray<V> of(V... data) {
    return new JSONArray<>(data);
  }

  /** Generator. */
  @Nonnull
  public static <V> JSONArray<V> of(@Nonnull Collection<? extends V> data) {
    return new JSONArray<>(data.toArray());
  }
}
