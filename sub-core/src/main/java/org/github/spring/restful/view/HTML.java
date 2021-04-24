package org.github.spring.restful.view;

import java.io.OutputStream;
import lombok.*;
import org.github.spring.restful.Returnable;
import com.google.common.net.MediaType;
import static com.google.common.net.MediaType.*;

/**
 * Top interface of html.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 */
@FunctionalInterface
public interface HTML extends Returnable {
  @Deprecated
  @Override
  default void accept(@NonNull OutputStream output) throws Exception {
    throw new UnsupportedOperationException();
  }

  @NonNull
  @Override
  default MediaType mediaType() {
    return HTML_UTF_8;
  }

  /** Generator. */
  @NonNull
  static HTML of(@NonNull String html) {
    return html::toString;
  }

  /** Generator. */
  @NonNull
  static HTML nil() {
    return () -> null;
  }
}
