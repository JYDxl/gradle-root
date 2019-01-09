package org.github.spring.restful.json;

import javax.annotation.Nonnull;
import static org.github.spring.footstone.IConstKt.COUNT;

/**
 * JSON of count.
 *
 * <pre>
 *   return JSONCount.of();
 * </pre>
 *
 * @author JYD_XL
 * @see org.github.spring.restful.Returnable
 * @see org.github.spring.restful.json.JSON
 * @see org.github.spring.footstone.AbstractEntity
 * @see org.github.spring.restful.json.JSONBasic
 */
public class JSONCount extends JSONBasic implements JSON {
  /** data. */
  private long data = COUNT;

  /** Constructor. */
  @SuppressWarnings("WeakerAccess")
  public JSONCount() {}

  /** Constructor. */
  @SuppressWarnings("WeakerAccess")
  public JSONCount(long data) {
    this.withData(data);
  }

  /** Constructor. */
  @SuppressWarnings("WeakerAccess")
  public JSONCount(int data) {
    this.withData(data);
  }

  /** Constructor. */
  @SuppressWarnings("WeakerAccess")
  public JSONCount(@Nonnull Long data) {
    this.withData(data);
  }

  /** Constructor. */
  @SuppressWarnings("WeakerAccess")
  public JSONCount(@Nonnull Integer data) {
    this.withData(data);
  }

  @Override
  @SuppressWarnings("deprecation")
  public void release() {
    data = COUNT;
    super.release();
  }

  /** GET data. */
  public long getData() {
    return data;
  }

  /** SET data. */
  public void setData(long data) {
    this.data = data;
  }

  /** WITH data. */
  @Nonnull
  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public JSONCount withData(long data) {
    this.setData(data);
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

  /** Generator. */
  @Nonnull
  public static JSONCount of(int data) {
    return new JSONCount(data);
  }

  /** Generator. */
  @Nonnull
  public static JSONCount of(@Nonnull Long data) {
    return new JSONCount(data);
  }

  /** Generator. */
  @Nonnull
  public static JSONCount of(@Nonnull Integer data) {
    return new JSONCount(data);
  }
}
