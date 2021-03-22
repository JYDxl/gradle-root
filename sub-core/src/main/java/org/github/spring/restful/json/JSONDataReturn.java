package org.github.spring.restful.json;

import javax.annotation.Nonnull;

import lombok.*;

/**
 * JSON of data.
 *
 * @param <T> data
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
public class JSONDataReturn<T> extends JSONReturn implements JSON {
  /** data. */
  private T data;

  /** WITH data. */
  public JSONDataReturn<T> withData(T data) {
    setData(data);
    return this;
  }

  /** Generator. */
  @Nonnull
  public static JSONDataReturn<?> of() {
    return new JSONDataReturn<>();
  }

  /** Generator. */
  @Nonnull
  public static <V> JSONDataReturn<V> of(V data) {
    return new JSONDataReturn<>(data);
  }
}
