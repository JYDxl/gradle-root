package org.github.core.spring.restful.json;

import com.google.common.net.MediaType;
import lombok.NonNull;
import org.github.core.spring.restful.Returnable;

import static com.google.common.net.MediaType.JSON_UTF_8;
import static org.github.core.spring.ops.SpringKt.json;

/**
 * Top interface of json.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see Returnable
 */
@FunctionalInterface
public interface JSON extends Returnable {
  @Override
  @NonNull
  default MediaType mediaType() {
    return JSON_UTF_8;
  }

  /** Generator. */
  @NonNull
  static JSON of(@NonNull Object data) {
    return of(json(data));
  }

  /** Generator. */
  @NonNull
  static JSON of(@NonNull String data) {
    return data::toString;
  }

  /** Generator. */
  @NonNull
  static JSON of() {
    return of("{}");
  }

  /** Generator. */
  @NonNull
  static JSON nil() {
    return () -> null;
  }
}
