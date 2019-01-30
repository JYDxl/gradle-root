package org.github.spring.restful.view;

import javax.annotation.Nonnull;
import org.github.spring.footstone.IConstKt;
import org.github.spring.restful.Returnable;
import org.jetbrains.annotations.Contract;

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
  default boolean terminal() {
    return false;
  }

  /** Generator. */
  @Contract(value = "_ -> param1", pure = true)
  @Nonnull
  static View of(@Nonnull View view) {
    return view;
  }

  /** Generator. */
  @Contract(pure = true)
  @Nonnull
  static View of(@Nonnull String view) {
    return view::toString;
  }

  /** Generator. */
  @Contract(pure = true)
  @Nonnull
  static View of() {
    return of(IConstKt.ROOT);
  }
}
