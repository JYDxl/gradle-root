package org.github.spring.restful.view;

import javax.annotation.Nonnull;
import org.github.spring.footstone.IConstKt;
import org.github.spring.restful.Returnable;

/**
 * Top interface of view.
 *
 * <pre>
 *   return View.of();
 * </pre>
 *
 * @author JYD_XL
 * @see org.github.spring.restful.Returnable
 */
@FunctionalInterface
@SuppressWarnings("ALL")
public interface View extends Returnable {
  @Override
  @Nonnull
  String get() throws Exception;

  @Deprecated
  @Override
  default void release() {}

  @Deprecated
  @Override
  default boolean terminal() {
    return false;
  }

  /** Generator. */
  static View of(@Nonnull View view) {
    return view;
  }

  /** Generator. */
  static View of(@Nonnull String view) {
    return of(view::toString);
  }

  /** Generator. */
  static View of(Object... part) {
    return of(IConstKt.getJOINER_EMPTY().join(part));
  }

  /** Generator. */
  static View of() {
    return of(IConstKt.ROOT);
  }
}
