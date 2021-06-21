package org.github.spring.restful.json;

import com.google.common.net.MediaType;
import lombok.NonNull;
import org.github.spring.restful.Returnable;

import static com.google.common.net.MediaType.JAVASCRIPT_UTF_8;

/**
 * Top interface of js.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 */
@FunctionalInterface
public interface JS extends Returnable {
  @Override
  default @NonNull MediaType mediaType() {
    return JAVASCRIPT_UTF_8;
  }

  /** Generator. */
  static @NonNull JS of(@NonNull String js) {
    return js::toString;
  }
}
