package org.github.core.spring.restful.json;

import com.google.common.net.MediaType;
import lombok.NonNull;
import org.github.core.spring.restful.Returnable;

/**
 * Top interface of js.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 */
@FunctionalInterface
public interface JS extends Returnable {
  @Override
  @NonNull
  default MediaType mediaType() {
    return MediaType.JAVASCRIPT_UTF_8;
  }

  /** Generator. */
  @NonNull
  static JS of(@NonNull String js) {
    return js::toString;
  }
}
