package org.github.core.spring.restful.json;

import io.swagger.annotations.ApiModelProperty;
import java.util.Collection;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
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
  @NotNull
  private Collection<? extends E> data = emptyList();

  @Override
  public String toString() {
    return get();
  }

  @NotNull
  public Collection<? extends E> getData() {
    return data;
  }

  /** WITH data. */
  @NotNull
  public JSONArray<E> withData(@NotNull Collection<? extends E> data) {
    setData(data);
    return this;
  }

  /** Generator. */
  @NotNull
  public static <V> JSONArray<V> of() {
    return new JSONArray<>();
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @NotNull
  public static <T, R extends T> JSONArray<R> of(@NotNull Collection<T> data) {
    return new JSONArray(data);
  }

  /** Generator. */
  @NotNull
  public static <T, R extends T> JSONArray<R> of(@NotNull Collection<T> data, @NotNull Function<T,R> mapper) {
    return new JSONArray<>(data.stream().map(mapper).collect(toImmutableList()));
  }
}
