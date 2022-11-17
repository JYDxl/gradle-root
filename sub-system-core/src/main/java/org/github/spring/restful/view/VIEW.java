package org.github.spring.restful.view;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.*;
import org.github.spring.restful.Returnable;
import com.google.common.net.MediaType;
import static com.google.common.net.MediaType.*;

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
  default void collect(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) throws Exception {
    throw new UnsupportedOperationException();
  }

  @Override
  @NonNull String get();

  @Override
  default @NonNull MediaType mediaType() {
    return HTML_UTF_8;
  }

  @Override
  default boolean terminated() {
    return false;
  }

  /** Generator. */
  static @NonNull VIEW of() {
    return of("/");
  }

  /** Generator. */
  static @NonNull VIEW of(@NonNull String view) {
    return view::toString;
  }
}
