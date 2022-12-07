package org.github.core.spring.restful.file;

import java.io.InputStream;
import javax.annotation.Nullable;
import lombok.*;
import org.github.core.spring.restful.Returnable;
import com.google.common.net.MediaType;
import static com.google.common.net.MediaType.*;

/**
 * Top interface of file.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see Returnable
 */
public interface FILE extends Returnable {
  @Override
  @NonNull
  default MediaType mediaType() {
    return OCTET_STREAM;
  }

  /**
   * Generator.
   */
  @NonNull
  static FILE of(@NonNull String name, @NonNull InputStream input) {
    return of(name, input, null);
  }

  /**
   * Generator.
   */
  @NonNull
  static FILE of(@NonNull String name, @NonNull InputStream input, @Nullable MediaType type) {
    return new FILEImpl(name, input, type);
  }
}
