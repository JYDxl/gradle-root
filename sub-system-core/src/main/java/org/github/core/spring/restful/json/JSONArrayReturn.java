package org.github.core.spring.restful.json;

import com.google.common.collect.ImmutableList;
import io.swagger.annotations.ApiModelProperty;
import java.util.Collection;
import java.util.function.Function;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
public class JSONArrayReturn<E> extends JSONReturn implements JSON {
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
  public JSONArrayReturn<E> withData(@NonNull Collection<? extends E> data) {
    setData(data);
    return this;
  }

  /** Generator. */
  @NonNull
  public static <V> JSONArrayReturn<V> of() {
    return new JSONArrayReturn<>();
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @NonNull
  public static <T, R extends T> JSONArrayReturn<R> of(@NonNull Collection<T> data) {
    return new JSONArrayReturn(data);
  }

  /** Generator. */
  @NonNull
  public static <T, R extends T> JSONArrayReturn<R> of(@NonNull Collection<T> data, @NonNull Function<T,R> mapper) {
    return new JSONArrayReturn<>(data.stream().map(mapper).collect(ImmutableList.toImmutableList()));
  }
}
