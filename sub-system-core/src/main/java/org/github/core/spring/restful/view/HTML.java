package org.github.core.spring.restful.view;

import com.google.common.net.MediaType;
import org.jetbrains.annotations.NotNull;
import org.github.core.spring.restful.Returnable;
import static com.google.common.net.MediaType.HTML_UTF_8;

/**
 * Top interface of html.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 */
@FunctionalInterface
public interface HTML extends Returnable {
  @Override
  @NotNull
  default MediaType mediaType() {
    return HTML_UTF_8;
  }

  /** Generator. */
  @NotNull
  static HTML of(@NotNull String html) {
    return html::toString;
  }
}
