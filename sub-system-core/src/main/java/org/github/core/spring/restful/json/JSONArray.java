package org.github.core.spring.restful.json;

import io.swagger.annotations.ApiModelProperty;
import java.util.Collection;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import static com.google.common.collect.ImmutableList.toImmutableList;
import static java.util.Collections.emptyList;

/**
 * JSON of array.
 *
 * @param <E> element
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JSONArray<E> extends JSONBase implements JSON {
  @ApiModelProperty("数据")
  @NonNull
  private Collection<? extends E> data = emptyList();

  @Override
  public String toString() {
    return get();
  }

  @NonNull
  public Collection<? extends E> getData() {
    return data;
  }

  /** WITH data. */
  @NonNull
  public JSONArray<E> withData(@NonNull Collection<? extends E> data) {
    setData(data);
    return this;
  }

  /** Generator. */
  @NonNull
  public static <V> JSONArray<V> of() {
    return new JSONArray<>();
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @NonNull
  public static <T, R extends T> JSONArray<R> of(@NonNull Collection<T> data) {
    return new JSONArray(data);
  }

  /** Generator. */
  @NonNull
  public static <T, R extends T> JSONArray<R> of(@NonNull Collection<T> data, @NonNull Function<T,R> mapper) {
    return new JSONArray<>(data.stream().map(mapper).collect(toImmutableList()));
  }
}
