package org.github.spring.restful.view;

import javax.annotation.Nonnull;
import org.github.spring.enumerate.ContentType;
import org.github.spring.footstone.IConstKt;
import org.github.spring.restful.Returnable;

/**
 * Top interface of view.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 */
@FunctionalInterface
public interface View extends Returnable {
  @Override
  @Nonnull
  default ContentType getContentType() {
    return ContentType.HTML;
  }

  @Override
  default boolean isTerminated() {
    return false;
  }

  /** Generator. */
  @Nonnull
  static View of(@Nonnull String view) {
    return view::toString;
  }

  /** Generator. */
  @Nonnull
  static View of() {
    return of(IConstKt.ROOT);
  }

  /** Generator. */
  @Deprecated
  @Nonnull
  static View nil() {
    return IConstKt.getViewNil();
  }
}
