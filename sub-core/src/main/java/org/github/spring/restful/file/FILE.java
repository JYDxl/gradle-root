package org.github.spring.restful.file;

import java.io.*;
import cn.hutool.core.io.IORuntimeException;
import lombok.*;
import org.github.exception.ParamsErrorException;
import org.github.spring.restful.Returnable;
import com.google.common.net.MediaType;
import org.springframework.core.io.Resource;

import static cn.hutool.core.util.URLUtil.encode;
import static com.google.common.net.MediaType.*;
import static java.lang.String.format;
import static java.util.Objects.requireNonNull;

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
    try {
      return new FILEImpl(encode(file.getName()), new FileInputStream(file));
    } catch (FileNotFoundException e) {
      throw new ParamsErrorException(format("文件[%s]不存在", file.getName()), e);
    }
  }

  /**
   * Generator.
   */
  static @NonNull FILE of(@NonNull String name, @NonNull InputStream input) {
    return new FILEImpl(encode(name), input);
  }

  /**
   * Generator.
   */
  static @NonNull FILE of(@NonNull Resource resource) {
    val name = requireNonNull(resource.getFilename());
    try {
      return new FILEImpl(name, resource.getInputStream());
    } catch (FileNotFoundException e) {
      throw new ParamsErrorException(format("文件[%s]不存在", name), e);
    } catch (IOException e) {
      throw new IORuntimeException(e);
    }
  }
}
