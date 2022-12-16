package org.github.core.spring.restful.file;

import com.google.common.net.MediaType;
import java.io.InputStream;
import org.jetbrains.annotations.Nullable;
import org.jetbrains.annotations.NotNull;
import org.github.core.spring.restful.Returnable;
import static com.google.common.net.MediaType.OCTET_STREAM;

/**
 * Top interface of file.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 */
public interface FILE extends Returnable {
  @Override
  @NotNull
  default MediaType mediaType() {
    return OCTET_STREAM;
  }

  /**
   * Generator.
   */
  @NotNull
  static FILE of(@NotNull String name, @NotNull InputStream input) {
    return of(name, input, null);
  }

  /**
   * Generator.
   */
  @NotNull
  static FILE of(@NotNull String name, @NotNull InputStream input, @Nullable MediaType type) {
    return new FILEImpl(name, input, type);
  }
}
