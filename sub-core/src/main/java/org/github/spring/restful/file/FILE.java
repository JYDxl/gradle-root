package org.github.spring.restful.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.Writer;
import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.github.spring.restful.Returnable;
import com.google.common.net.MediaType;
import static com.google.common.io.ByteStreams.*;
import static com.google.common.net.MediaType.*;

/**
 * Top interface of file.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 */
@FunctionalInterface
public interface FILE extends Returnable {
  @Deprecated
  @Override
  default String get() {
    throw new UnsupportedOperationException();
  }

  @Deprecated
  @Override
  default void accept(@Nonnull Writer writer) throws Exception {
    throw new UnsupportedOperationException();
  }

  @Override
  default void accept(@Nonnull OutputStream output) throws Exception {
    try(InputStream input = info().input) {
      copy(input, output);
    }
  }

  @Override
  default void collect(@Nonnull HttpServletRequest req, @Nonnull HttpServletResponse res) throws Exception {
    res.addHeader("Content-Disposition", "attachment;filename=" + info().name);
    Returnable.super.collect(req, res);
  }

  @Override
  default boolean functional() {
    return false;
  }

  @Nonnull
  @Override
  default MediaType mediaType() {
    return OCTET_STREAM;
  }

  @Nonnull
  Info info();

  /** Generator. */
  @Nonnull
  static FILE of(@Nonnull File file) {
    try {
      return of(new Info(file.getName(), new FileInputStream(file)));
    } catch(FileNotFoundException e) {
      throw new RuntimeException(e);
    }
  }

  /** Generator. */
  @Nonnull
  static FILE of(@Nonnull Info info) {
    return () -> info;
  }

  /** Generator. */
  @Nonnull
  static FILE of(@Nonnull String name, @Nonnull InputStream input) {
    return of(new Info(name, input));
  }

  final class Info {
    private final String name;

    private final InputStream input;

    public Info(String name, InputStream input) {
      this.name = name;
      this.input = input;
    }
  }
}
