package org.github.spring.restful.json;

import lombok.*;
import org.github.spring.restful.Returnable;
import com.google.common.net.MediaType;
import static com.google.common.net.MediaType.*;
import static org.github.spring.ops.SpringKt.*;

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
  @NonNull
  default MediaType mediaType() {
    return JSON_UTF_8;
  }

  /** Generator. */
  @NonNull
  static JSON of(@NonNull Object json) {
    return of(json(json));
  }

  /** Generator. */
  @NonNull
  static JSON of(@NonNull String json) {
    return json::toString;
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
