package org.github.spring.restful.json;

import javax.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import static org.github.spring.footstone.IConstKt.*;

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
  private long data = COUNT;

  @Override
  public void release() {
    data = COUNT;
    super.release();
  }

  @Override
  public String toString() {
    return get();
  }

  /** WITH data. */
  @Nonnull
  public JSONCount withData(long data) {
    setData(data);
    return this;
  }

  /** Generator. */
  @Nonnull
  public static JSONCount of() {
    return new JSONCount();
  }

  /** Generator. */
  @Nonnull
  public static JSONCount of(long data) {
    return new JSONCount(data);
  }
}
