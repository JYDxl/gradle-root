package org.github.spring.restful.view;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.github.spring.restful.Returnable;
import com.google.common.net.MediaType;

import java.io.OutputStream;
import java.io.Writer;

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
  @Nonnull
  @Override
  String get();

  @Deprecated
  @Override
  default void accept(@Nonnull Writer writer) throws Exception {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  @Override
  default void accept(@Nonnull OutputStream output) throws Exception {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  @Override
  default void collect(@Nonnull HttpServletRequest req, @Nonnull HttpServletResponse res) throws Exception {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  @Override
  default boolean functional() {
    throw new UnsupportedOperationException();
  }

  @Nonnull
  @Override
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
    return () -> ROOT;
  }
}
