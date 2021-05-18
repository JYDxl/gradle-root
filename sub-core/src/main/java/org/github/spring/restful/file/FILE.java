package org.github.spring.restful.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.Writer;
import lombok.*;
import org.github.exception.ParamsErrorException;
import org.github.spring.restful.Returnable;
import com.google.common.net.MediaType;
import static com.google.common.net.MediaType.*;

/**
 * Top interface of file.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 */
public interface FILE extends Returnable {
  @NonNull
  @Override
  default MediaType mediaType() {
    return OCTET_STREAM;
  }

  @Deprecated
  @Override
  default boolean functional() {
    return false;
  }

  @Deprecated
  @Override
  default void accept(@NonNull Writer writer) {
    throw new UnsupportedOperationException();
  }

  @NonNull
  @Override
  String get();

  /**
   * Generator.
   */
  @NonNull
  static FILE of(@NonNull File file) {
    try {
      return new FILEImpl(file.getName(), new FileInputStream(file));
    } catch (FileNotFoundException e) {
      throw new ParamsErrorException(e);
    }
  }

  /**
   * Generator.
   */
  @NonNull
  static FILE of(@NonNull String name, @NonNull InputStream input) {
    return new FILEImpl(name, input);
  }
}
