package org.github.spring.restful.json;

import java.io.OutputStream;
import javax.annotation.Nonnull;
import org.github.spring.enumeration.ContentType;
import org.github.spring.restful.Returnable;
import static org.github.spring.enumeration.ContentType.JSON;
import static org.github.spring.footstone.IConstKt.EMPTY_JSON;
import static org.github.spring.footstone.IConstKt.getJSON_WRAPPER;

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
  default void accept(@Nonnull OutputStream output) throws Exception {
    getJSON_WRAPPER().writeValue(output, this);
  }

  @Nonnull
  @Deprecated
  @Override

  @SuppressWarnings("deprecation")
  default ContentType contentType() {
    return JSON;
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
    return of(getJSON_WRAPPER().writeValueAsString(json));
  }

  /** Generator. */

  @Nonnull
  static JSON of() {
    return of(EMPTY_JSON);
  }
}
