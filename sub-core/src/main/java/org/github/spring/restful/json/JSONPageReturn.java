package org.github.spring.restful.json;

import java.util.List;
import lombok.*;
import com.baomidou.mybatisplus.core.metadata.IPage;
import static org.github.spring.footstone.IConstKt.*;

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
@Data
public class JSONPageReturn<E> extends JSONArrayReturn<E> implements JSON {
  /** total. */
  private long total = COUNT;

  @Override
  public String toString() {
    return get();
  }

  /** WITH total. */
  @NonNull
  public JSONPageReturn<E> withTotal(long total) {
    setTotal(total);
    return this;
  }

  /** Generator. */
  @NonNull
  public static JSONPageReturn<?> of() {
    return new JSONPageReturn<>();
  }

  /** Generator. */
  @NonNull
  public static <V> JSONPageReturn<V> of(@NonNull IPage<? extends V> page) {
    return (JSONPageReturn<V>) new JSONPageReturn<V>(page.getTotal()).withData(page.getRecords());
  }

  /** Generator. */
  @NonNull
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static <V> JSONPageReturn<V> of(long total, @NonNull List<? extends V> data) {
    return (JSONPageReturn) new JSONPageReturn<>(total).withData(data);
  }
}
