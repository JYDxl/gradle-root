package org.github.spring.restful.json;

import javax.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.github.spring.footstone.IConstKt;
import org.jetbrains.annotations.Contract;

/**
 * JSON of count.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 * @see org.github.spring.restful.json.JSON
 * @see org.github.spring.restful.json.JSONBasic
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JSONCount extends JSONBasic implements JSON {
  /** data. */
  private long data = IConstKt.COUNT;

  @Override
  public void release() {
    data = IConstKt.COUNT;
    super.release();
  }

  @Override
  public String toString() {
    return super.toString();
  }

  /** WITH data. */
  @Nonnull
  public JSONCount withData(long data) {
    setData(data);
    return this;
  }

  /** Generator. */
  @Contract(" -> new")
  @Nonnull
  public static JSONCount of() {
    return new JSONCount();
  }

  /** Generator. */
  @Contract("_ -> new")
  @Nonnull
  public static JSONCount of(long data) {
    return new JSONCount(data);
  }
}
