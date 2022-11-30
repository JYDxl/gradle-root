package org.github.spring.restful.view;

import lombok.*;
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
