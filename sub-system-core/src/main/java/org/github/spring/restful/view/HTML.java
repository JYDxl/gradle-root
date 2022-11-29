package org.github.spring.restful.view;

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
  @Override
  @NonNull
  default MediaType mediaType() {
    return HTML_UTF_8;
  }

  /** Generator. */
  @NonNull
  static HTML of(@NonNull String html) {
    return html::toString;
  }
}
