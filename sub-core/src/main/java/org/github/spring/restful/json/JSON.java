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
 * <pre>
 *   return JSON.of();
 * </pre>
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see org.github.spring.restful.Returnable
 */
@FunctionalInterface
public interface JSON extends Returnable {
  @Deprecated
  @Override
  @SuppressWarnings("deprecation")
  default void accept(@Nonnull OutputStream output) {
    ObjectOpsKt.writeValue(this, output);
  }

  @Nonnull
  @Deprecated
  @Override
  @SuppressWarnings("deprecation")
  default ContentType contentType() {
    return ContentType.JSON;
  }

  @Override
  @Nonnull
  String get() throws Exception;

  /** Generator. */
  @Nonnull
  static JSON of(JSON json) {
    return json;
  }

  /** Generator. */
  @Nonnull
  static JSON of(@Nonnull String json) {
    return () -> json;
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
}
