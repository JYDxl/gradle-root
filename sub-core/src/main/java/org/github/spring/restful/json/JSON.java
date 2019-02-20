package org.github.spring.restful.json;

import java.io.OutputStream;
import javax.annotation.Nonnull;
import org.github.ops.ObjectOpsKt;
import org.github.spring.enumerate.ContentType;
import org.github.spring.footstone.IConstKt;
import org.github.spring.restful.Returnable;

/**
 * Top interface of json.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 */
@FunctionalInterface
public interface JSON extends Returnable {
  @Override
  default void accept(@Nonnull OutputStream output) {
    ObjectOpsKt.writeValue(this, output);
  }

  @Override
  @Nonnull
  default ContentType getContentType() {
    return ContentType.JSON;
  }

  /** Generator. */
  @Nonnull
  static JSON of(@Nonnull String json) {
    return json::toString;
  }

  /** Generator. */
  @Nonnull
  static JSON of(@Nonnull Object json) {
    return of(ObjectOpsKt.json(json));
  }

  /** Generator. */
  @Nonnull
  static JSON of() {
    return of(IConstKt.EMPTY_JSON);
  }

  /** Generator. */
  @Nonnull
  static JSON nil() {
    return IConstKt.getJsonNil();
  }
}
