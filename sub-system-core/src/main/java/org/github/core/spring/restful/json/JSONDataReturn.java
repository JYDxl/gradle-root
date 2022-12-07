package org.github.core.spring.restful.json;

import java.util.function.Function;
import javax.annotation.Nullable;
import lombok.*;
import org.github.core.spring.restful.Returnable;

import static java.util.Optional.*;

/**
 * JSON of data.
 *
 * @param <T> data
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see Returnable
 * @see JSON
 * @see JSONReturn
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JSONDataReturn<T> extends JSONReturn implements JSON {
  /** 数据 */
  private @Nullable T data;

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
  public static <V> JSONDataReturn<V> of() {
    return new JSONDataReturn<>();
  }

  /** Generator. */
  @NonNull
  public static <T, R extends T> JSONDataReturn<R> of(T data, @NonNull Function<T,R> mapper) {
    return of(ofNullable(data).map(mapper).orElse(null));
  }

  /** Generator. */
  @NonNull
  public static <V> JSONDataReturn<V> of(V data) {
    return new JSONDataReturn<>(data);
  }
}
