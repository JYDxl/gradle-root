package org.github.spring.restful.json;

import java.io.OutputStream;
import lombok.*;
import org.github.spring.restful.Returnable;
import com.google.common.net.MediaType;
import static com.google.common.net.MediaType.*;
import static org.github.ops.spring.SpringOpsKt.*;
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
  default void accept(@NonNull OutputStream output) {
    writeValue(this, output, null);
  }

  @NonNull
  @Override
  default MediaType mediaType() {
    return JSON_UTF_8;
  }

  /** Generator. */
  @NonNull
  static JSON of(@NonNull String json) {
    return json::toString;
  }

  /** Generator. */
  @NonNull
  static JSON of(@NonNull Object json) {
    return of(json(json, null));
  }

  /** Generator. */
  @NonNull
  static JSON of() {
    return () -> EMPTY_JSON;
  }

  /** Generator. */
  @NonNull
  static JSON nil() {
    return () -> null;
  }
}
