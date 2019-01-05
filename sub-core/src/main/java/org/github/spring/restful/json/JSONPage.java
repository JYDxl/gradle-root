package org.github.spring.restful.json;

import java.util.Collection;

import static org.github.spring.footstone.IConstKt.COUNT;

/**
 * JSON_ENCODER of page.
 *
 * <pre>
 *   return JSONPage.of();
 * </pre>
 *
 * @param <E> element
 * @author JYD_XL
 * @see java.io.Serializable
 * @see org.github.spring.restful.Returnable
 * @see org.github.spring.restful.json.JSON
 * @see org.github.spring.footstone.AbstractEntity
 * @see org.github.spring.restful.json.JSONBasic
 * @see org.github.spring.restful.json.JSONArray
 */
@SuppressWarnings("ALL")
public class JSONPage<E> extends JSONArray<E> implements JSON {
  /** total. */
  private long total = COUNT;

  /** Constructor. */
  public JSONPage() {}

  /** Constructor. */
  @SafeVarargs
  public JSONPage(long total, E... data) {
    this.withTotal(total).withData(data);
  }

  /** Constructor. */
  public JSONPage(long total, Collection<? extends E> data) {
    this.withTotal(total).withData(data);
  }

  // /** Constructor. */
  // public JSONPage(@NotNull List<? extends E> page) {
  //   this((Page<? extends E>) page);
  // }
  //
  // /** Constructor. */
  // public JSONPage(@NotNull List<? super E> page, @NotNull Class<? extends E> data) {
  //   this((Page<? super E>) page, data);
  // }
  //
  // /** Constructor. */
  // public JSONPage(@NotNull List<? super E> page, E[] data) {
  //   this((Page<? super E>) page, data);
  // }
  //
  // /** Constructor. */
  // public JSONPage(@NotNull List<? super E> page, Collection<? extends E> data) {
  //   this((Page<? super E>) page, data);
  // }
  //
  // /** Constructor. */
  // @Deprecated
  // public JSONPage(@NotNull Page<? extends E> page) {
  //   this(page.getTotal(), (E[]) page.toArray());
  // }
  //
  // /** Constructor. */
  // @Deprecated
  // public JSONPage(@NotNull Page<? super E> page, @NotNull Class<? extends E> data) {
  //   this(page.getTotal(), (E[]) copy(data, page));
  // }
  //
  // /** Constructor. */
  // @SafeVarargs
  // @Deprecated
  // public JSONPage(@NotNull Page<? super E> page, E... data) {
  //   this(page.getTotal(), data);
  // }
  //
  // /** Constructor. */
  // public JSONPage(@NotNull Page<? super E> page, Collection<? extends E> data) {
  //   this(page.getTotal(), data);
  // }

  @Override
  public void release() {
    total = COUNT;
    super.release();
  }

  /** GET total. */
  public long getTotal() {
    return total;
  }

  /** SET total. */
  public void setTotal(long total) {
    this.total = total;
  }

  /** WITH total. */
  public JSONPage<E> withTotal(long total) {
    this.setTotal(total);
    return this;
  }

  /** Generator. */
  public static JSONPage of() {
    return new JSONPage();
  }

  // /** Generator. */
  // public static <V> JSONPage<V> of(@NotNull List<? extends V> page) {
  //   return new JSONPage<>(page);
  // }
  //
  // /** Generator. */
  // public static <V> JSONPage<V> of(@NotNull List<? super V> page, @NotNull Class<? extends V> data) {
  //   return new JSONPage<>(page, data);
  // }
  //
  // /** Generator. */
  // @SafeVarargs
  // public static <V> JSONPage<V> of(@NotNull List<? super V> page, V... data) {
  //   return new JSONPage<>(page, data);
  // }
  //
  // /** Generator. */
  // public static <V> JSONPage<V> of(@NotNull List<? super V> page, Collection<? extends V> data) {
  //   return new JSONPage<>(page, data);
  // }
}
