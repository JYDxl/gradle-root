package org.github.spring.restful.json;

import javax.annotation.Nonnull;

import lombok.*;
import com.baomidou.mybatisplus.core.metadata.IPage;

import static org.github.spring.footstone.IConstKt.*;
import static org.github.util.BeansUtilKt.*;

/**
 * JSON of page.
 *
 * @param <E> element
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 * @see org.github.spring.restful.json.JSON
 * @see JSONReturn
 * @see JSONArrayReturn
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JSONPageReturn<E> extends JSONArrayReturn<E> implements JSON {
  /** total. */
  private long total = COUNT;

  /** WITH total. */
  @Nonnull
  public JSONPageReturn<E> withTotal(long total) {
    setTotal(total);
    return this;
  }

  /** Generator. */
  @Nonnull
  public static JSONPageReturn<?> of() {
    return new JSONPageReturn<>();
  }

  /** Generator. */
  @Nonnull
  public static <V> JSONPageReturn<V> of(@Nonnull IPage<? extends V> page) {
    return (JSONPageReturn<V>) new JSONPageReturn<V>(page.getTotal()).withData(page.getRecords());
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @Nonnull
  public static <V> JSONPageReturn<V> of(@Nonnull IPage<? super V> page, @Nonnull Class<? extends V> data) {
    return (JSONPageReturn) new JSONPageReturn<>(page.getTotal()).withData(copy(data, page.getRecords()));
  }
}
