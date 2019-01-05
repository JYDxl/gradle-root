package org.github.spring.restful.json;

import java.io.OutputStream;

import org.github.spring.enumeration.ContentType;
import org.github.spring.restful.Returnable;

import org.jetbrains.annotations.NotNull;

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
  default void accept(@NotNull OutputStream output) throws Exception {
    getJSON_WRAPPER().writeValue(output, this);
  }

  @NotNull
  @Deprecated
  @Override

  @SuppressWarnings("deprecation")
  default ContentType contentType() {
    return JSON;
  }

  @Override
  @NotNull
  String get() throws Exception;

  /** Generator. */
  @NotNull
  static JSON of(JSON json) {
    return json;
  }

  /** Generator. */
  @NotNull
  static JSON of(String json) {
    return json::toString;
  }

  /** Generator. */
  @NotNull
  static JSON of(Object json) {
    return of(getJSON_WRAPPER().writeValueAsString(json));
  }

  /** Generator. */

  @NotNull
  static JSON of() {
    return of(EMPTY_JSON);
  }
}
