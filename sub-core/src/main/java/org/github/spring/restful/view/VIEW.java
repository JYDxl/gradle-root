package org.github.spring.restful.view;

import javax.annotation.Nonnull;
import org.github.spring.restful.Returnable;
import com.google.common.net.MediaType;
import static com.google.common.net.MediaType.*;
import static org.github.spring.footstone.IConstKt.*;

/**
 * Top interface of view.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 */
@FunctionalInterface
public interface VIEW extends Returnable {
  @Override
  @Nonnull
  String get();

  @Override
  @Nonnull
  default MediaType mediaType() {
    return HTML_UTF_8;
  }

  @Override
  default boolean terminated() {
    return false;
  }

  /** Generator. */
  @Nonnull
  static VIEW of(@Nonnull String view) {
    return view::toString;
  }

  /** Generator. */
  @Nonnull
  static VIEW of() {
    return getViewRoot();
  }
}
