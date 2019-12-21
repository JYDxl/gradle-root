package org.github.spring.restful.json;

import javax.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
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
 * @see org.github.spring.restful.json.JSONBasic
 * @see org.github.spring.restful.json.JSONArray
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JSONPage<E> extends JSONArray<E> implements JSON {
  /** total. */
  private long total = COUNT;

  @Override
  public void release() {
    total = COUNT;
    super.release();
  }

  @Override
  public String toString() {
    return get();
  }

  /** WITH total. */
  @Nonnull
  public JSONPage<E> withTotal(long total) {
    setTotal(total);
    return this;
  }

  /** Generator. */
  @Nonnull
  public static JSONPage<?> of() {
    return new JSONPage<>();
  }

  /** Generator. */
  @Nonnull
  public static <V> JSONPage<V> of(@Nonnull IPage<? extends V> page) {
    return (JSONPage<V>) new JSONPage<V>(page.getTotal()).withData(page.getRecords());
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @Nonnull
  public static <V> JSONPage<V> of(@Nonnull IPage<? super V> page, @Nonnull Class<? extends V> data) {
    return (JSONPage) new JSONPage<>(page.getTotal()).withData(copy(data, page.getRecords()));
  }
}
