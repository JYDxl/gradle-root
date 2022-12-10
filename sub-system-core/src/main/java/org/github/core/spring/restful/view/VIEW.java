package org.github.core.spring.restful.view;

import lombok.NonNull;
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
  @NonNull
  static VIEW of() {
    return of("/");
  }

  /** Generator. */
  @NonNull
  static VIEW of(@NonNull String view) {
    return view::toString;
  }
}
