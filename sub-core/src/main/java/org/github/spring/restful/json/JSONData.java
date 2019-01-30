package org.github.spring.restful.json;

import javax.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.Contract;

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
    return super.toString();
  }

  /** WITH data. */
  public JSONData<T> withData(T data) {
    setData(data);
    return this;
  }

  /** Generator. */
  @Contract(" -> new")
  @Nonnull
  public static JSONData of() {
    return new JSONData();
  }

  /** Generator. */
  @Contract("_ -> new")
  @Nonnull
  public static <V> JSONData<V> of(V data) {
    return new JSONData<>(data);
  }
}
