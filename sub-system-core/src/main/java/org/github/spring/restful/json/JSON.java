package org.github.spring.restful.json;

import java.io.OutputStream;
import lombok.*;
import org.github.spring.restful.Returnable;
import com.google.common.net.MediaType;
import static com.google.common.net.MediaType.*;
import static javax.servlet.http.HttpServletResponse.*;
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

  int CODE_PARAMS_ERROR = SC_BAD_REQUEST;

  int CODE_404_ERROR = SC_NOT_FOUND;

  int CODE_SYSTEM_ERROR = SC_INTERNAL_SERVER_ERROR;

  int CODE_AUTH_ERROR = SC_UNAUTHORIZED;
}
