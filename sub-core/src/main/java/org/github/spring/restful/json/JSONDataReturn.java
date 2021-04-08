package org.github.spring.restful.json;

import java.util.function.Function;
import lombok.*;
import static java.util.Optional.*;

/**
 * JSON of data.
 *
 * @param <T> data
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
public class JSONDataReturn<T> extends JSONReturn implements JSON {
  /** data. */
  private T data;

  @Override
  public String toString() {
    return get();
  }

  /** WITH data. */
  public JSONDataReturn<T> withData(T data) {
    setData(data);
    return this;
  }

  /** Generator. */
  @NonNull
  public static JSONDataReturn<?> of() {
    return new JSONDataReturn<>();
  }

  /** Generator. */
  @NonNull
  public static <V> JSONDataReturn<V> of(V data) {
    return new JSONDataReturn<>(data);
  }

  /** Generator. */
  @NonNull
  public static <T, R> JSONDataReturn<R> of(T data, @NonNull Function<T,R> mapper) {
    return of(ofNullable(data).map(mapper).orElse(null));
  }
}
