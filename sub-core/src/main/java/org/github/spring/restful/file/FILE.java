package org.github.spring.restful.file;

import com.google.common.net.MediaType;
import org.github.spring.restful.Returnable;

import javax.annotation.Nonnull;
import java.io.*;

import static com.google.common.net.MediaType.OCTET_STREAM;

/**
 * Top interface of file.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 */
public interface FILE extends Returnable {
  @Nonnull
  @Override
  String get();

  @Deprecated
  @Override
  default void accept(@Nonnull Writer writer) {
    throw new UnsupportedOperationException();
  }

  @Override
  void accept(@Nonnull OutputStream output) throws Exception;

  @Override
  default boolean functional() {
    return false;
  }

  @Nonnull
  @Override
  default MediaType mediaType() {
    return OCTET_STREAM;
  }

  /**
   * Generator.
   */
  @Nonnull
  static FILE of(@Nonnull File file) {
    try {
      return new FILEImpl(file.getName(), new FileInputStream(file));
    } catch(FileNotFoundException e) {
      throw new IllegalArgumentException(e);
    }
  }

  /**
   * Generator.
   */
  @Nonnull
  static FILE of(@Nonnull String name, @Nonnull InputStream input) {
    return new FILEImpl(name, input);
  }
}
