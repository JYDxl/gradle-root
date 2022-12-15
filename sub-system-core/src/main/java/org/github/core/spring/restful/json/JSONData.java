package org.github.core.spring.restful.json;

import io.swagger.annotations.ApiModelProperty;
import java.util.function.Function;
import javax.annotation.Nullable;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import static java.util.Optional.ofNullable;

/**
 * JSON of data.
 *
 * @param <T> data
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JSONData<T> extends JSONBase implements JSON {
  @ApiModelProperty("数据")
  @Nullable
  private T data;

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
  @NonNull
  public static <V> JSONData<V> of() {
    return new JSONData<>();
  }

  /** Generator. */
  @NonNull
  public static <T, R extends T> JSONData<R> of(T data, @NonNull Function<T,R> mapper) {
    return of(ofNullable(data).map(mapper).orElse(null));
  }

  /** Generator. */
  @NonNull
  public static <V> JSONData<V> of(V data) {
    return new JSONData<>(data);
  }
}
