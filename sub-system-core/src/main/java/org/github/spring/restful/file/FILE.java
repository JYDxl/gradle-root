package org.github.spring.restful.file;

import java.io.*;
import cn.hutool.core.io.IORuntimeException;
import lombok.*;
import org.github.exception.ParamsErrorException;
import org.github.spring.restful.Returnable;
import com.google.common.net.MediaType;
import org.springframework.core.io.Resource;

import javax.annotation.Nullable;

import static cn.hutool.core.util.URLUtil.*;
import static com.google.common.net.MediaType.*;
import static java.lang.String.*;
import static java.util.Objects.*;

/**
 * Top interface of file.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 */
public interface FILE extends Returnable {
  @Override
  default @NonNull MediaType mediaType() {
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

  @Override
  @NonNull String get();

  /**
   * Generator.
   */
  static @NonNull FILE of(@NonNull File file) {
    return of(file, null);
  }

  /**
   * Generator.
   */
  static @NonNull FILE of(@NonNull File file, @Nullable MediaType type) {
    try {
      return new FILEImpl(encode(file.getName()), new FileInputStream(file), type);
    } catch (FileNotFoundException e) {
      throw new ParamsErrorException(format("文件[%s]不存在", file.getName()), e);
    }
  }

  /**
   * Generator.
   */
  static @NonNull FILE of(@NonNull String name, @NonNull InputStream input) {
    return of(name, input, null);
  }

  /**
   * Generator.
   */
  static @NonNull FILE of(@NonNull String name, @NonNull InputStream input, @Nullable MediaType type) {
    return new FILEImpl(encode(name), input, type);
  }

  /**
   * Generator.
   */
  static @NonNull FILE of(@NonNull Resource resource) {
    return of(resource, null);
  }

  /**
   * Generator.
   */
  static @NonNull FILE of(@NonNull Resource resource, @Nullable MediaType type) {
    val name = requireNonNull(resource.getFilename());
    try {
      return new FILEImpl(name, resource.getInputStream(), type);
    } catch (FileNotFoundException e) {
      throw new ParamsErrorException(format("文件[%s]不存在", decode(name)), e);
    } catch (IOException e) {
      throw new IORuntimeException(e);
    }
  }
}