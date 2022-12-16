package org.github.core.spring.restful.view;

import org.jetbrains.annotations.NotNull;
import org.github.core.spring.restful.Returnable;

/**
 * Top interface of view.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 */
@FunctionalInterface
public interface VIEW extends Returnable {
  @Override
  default boolean terminated() {
    return false;
  }

  /** Generator. */
  @NotNull
  static VIEW of() {
    return of("/");
  }

  /** Generator. */
  @NotNull
  static VIEW of(@NotNull String view) {
    return view::toString;
  }
}
