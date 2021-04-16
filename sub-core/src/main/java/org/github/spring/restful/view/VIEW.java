package org.github.spring.restful.view;

import java.io.OutputStream;
import java.io.Writer;
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
  @NonNull
  @Override
  String get();

  @Deprecated
  @Override
  default void accept(@NonNull Writer writer) throws Exception {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  @Override
  default void accept(@NonNull OutputStream output) throws Exception {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  @Override
  default void collect(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) throws Exception {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  @Override
  default boolean functional() {
    throw new UnsupportedOperationException();
  }

  @NonNull
  @Override
  default MediaType mediaType() {
    return HTML_UTF_8;
  }

  @Override
  default boolean terminated() {
    return false;
  }

  /** Generator. */
  @NonNull
  static VIEW of(@NonNull String view) {
    //noinspection NullableProblems
    return view::toString;
  }

  /** Generator. */
  @NonNull
  static VIEW of() {
    return of("/");
  }
}
