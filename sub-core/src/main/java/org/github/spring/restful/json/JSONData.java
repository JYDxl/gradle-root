package org.github.spring.restful.json;

import javax.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * JSON of data.
 *
 * @param <T> data
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
public class JSONData<T> extends JSONBasic implements JSON {
  /** data. */
  private T data;

  @Override
  public void release() {
    data = null;
    super.release();
  }

  @Override
  public String toString() {
    return get();
  }

  /** WITH data. */
  public JSONData<T> withData(T data) {
    setData(data);
    return this;
  }

  /** Generator. */
  @Nonnull
  public static JSONData of() {
    return new JSONData();
  }

  /** Generator. */
  @Nonnull
  public static <V> JSONData<V> of(V data) {
    return new JSONData<>(data);
  }
}
