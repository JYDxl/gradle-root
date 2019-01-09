package org.github.spring.restful.json;

import java.util.Collection;
import java.util.List;
import java.util.stream.Stream;
import javax.annotation.Nonnull;
import static java.util.Arrays.asList;
import static java.util.Arrays.stream;
import static org.github.spring.footstone.IConstKt.getARRAY;

/**
 * JSON of array.
 *
 * <pre>
 *   return JSONArray.of();
 * </pre>
 *
 * @param <E> element
 * @author JYD_XL
 * @see org.github.spring.restful.Returnable
 * @see org.github.spring.restful.json.JSON
 * @see org.github.spring.footstone.AbstractEntity
 * @see org.github.spring.restful.json.JSONBasic
 */
public class JSONArray<E> extends JSONBasic implements JSON {
  /** data. */
  @Nonnull
  private Object[] data = getARRAY();

  /** Constructor. */
  @SuppressWarnings("WeakerAccess")
  public JSONArray() {}

  /** Constructor. */
  @SafeVarargs
  @SuppressWarnings("WeakerAccess")
  public JSONArray(E... data) {
    this.withData(data);
  }

  /** Constructor. */
  @SuppressWarnings("WeakerAccess")
  public JSONArray(@Nonnull Collection<? extends E> data) {
    this.withData(data);
  }

  @Override
  @SuppressWarnings("deprecation")
  public void release() {
    data = getARRAY();
    super.release();
  }

  /** GET data. */
  @Nonnull
  public Object[] getData() {
    return data;
  }

  /** SET data. */
  public void setData(@Nonnull Object[] data) {
    this.data = data;
  }

  /** GET data. */
  @Nonnull
  @SuppressWarnings("unchecked")
  public E[] toArray() {
    return (E[]) this.getData();
  }

  /** GET data. */
  @Nonnull
  @SuppressWarnings("unchecked")
  public List<E> toList() {
    return (List<E>) asList(data);
  }

  /** GET data. */
  @Nonnull
  @SuppressWarnings("unchecked")
  public Stream<E> toStream() {
    return (Stream<E>) stream(data);
  }

  /** WITH data. */


  @SafeVarargs
  @Nonnull
  public final JSONArray<E> withData(E... data) {
    this.data = data;
    return this;
  }

  /** WITH data. */
  @Nonnull
  @SuppressWarnings("UnusedReturnValue")
  public JSONArray<E> withData(@Nonnull Collection<? extends E> data) {
    this.data = data.toArray();
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
    return new JSONArray<>(data);
  }
}
