package org.github.core.spring.restful.json;

import com.google.common.net.MediaType;
import org.jetbrains.annotations.NotNull;
import org.github.core.spring.restful.Returnable;
import static com.google.common.net.MediaType.JSON_UTF_8;
import static org.github.core.spring.ops.SpringKt.json;

/**
 * Top interface of json.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 */
@FunctionalInterface
public interface JSON extends Returnable {
  @Override
  @NotNull
  default MediaType mediaType() {
    return JSON_UTF_8;
  }

  /** Generator. */
  @NotNull
  static JSON of(@NotNull Object data) {
    return of(json(data));
  }

  /** Generator. */
  @NotNull
  static JSON of(@NotNull String data) {
    return data::toString;
  }

  /** Generator. */
  @NotNull
  static JSON of() {
    return of("{}");
  }

  /** Generator. */
  @NotNull
  static JSON nil() {
    return () -> null;
  }
}
