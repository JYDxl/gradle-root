package org.github.spring.restful.json;

import java.io.OutputStream;
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
  default @NonNull MediaType mediaType() {
    return JSON_UTF_8;
  }

  @Override
  default void accept(@NonNull OutputStream output) {
    writeValue(this, output);
  }

  /** Generator. */
  static @NonNull JSON of(@NonNull Object json) {
    return of(json(json));
  }

  /** Generator. */
  static @NonNull JSON of(@NonNull String json) {
    return json::toString;
  }

  /** Generator. */
  static @NonNull JSON of() {
    return of("{}");
  }

  /** Generator. */
  static @NonNull JSON nil() {
    return () -> null;
  }

  int CODE_OK = 0;

  int CODE_PARAMS_ERROR = -1;

  int CODE_SYSTEM_ERROR = -2;
}
