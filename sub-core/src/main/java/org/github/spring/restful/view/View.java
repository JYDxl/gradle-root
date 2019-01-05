package org.github.spring.restful.view;


import org.github.spring.restful.Returnable;

import org.jetbrains.annotations.NotNull;

import static org.github.spring.footstone.IConstKt.ROOT;
import static org.github.spring.footstone.IConstKt.getJOINER_EMPTY;

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
  @NotNull
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
  static View of(@NotNull View view) {
    return view;
  }

  /** Generator. */
  static View of(@NotNull String view) {
    return of(view::toString);
  }

  /** Generator. */
  static View of(Object... part) {
    return of(getJOINER_EMPTY().join(part));
  }

  /** Generator. */
  static View of() {
    return of(ROOT);
  }
}
