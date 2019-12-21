package org.github.spring.restful.json;

import java.io.OutputStream;
import javax.annotation.Nonnull;
import org.github.spring.restful.Returnable;
import com.google.common.net.MediaType;
import static com.google.common.net.MediaType.*;
import static org.github.ops.ObjectOpsKt.*;
import static org.github.spring.footstone.IConstKt.*;

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
    writeValue(this, output, null);
  }

  @Override
  @Nonnull
  default MediaType mediaType() {
    return JSON_UTF_8;
  }

  /** Generator. */
  @Nonnull
  static JSON of(@Nonnull String json) {
    return json::toString;
  }

  /** Generator. */
  @Nonnull
  static JSON of(@Nonnull Object json) {
    return of(json(json, null));
  }

  /** Generator. */
  @Nonnull
  static JSON of() {
    return getJsonEmpty();
  }

  /** Generator. */
  @Nonnull
  static JSON nil() {
    return getJsonNil();
  }
}
