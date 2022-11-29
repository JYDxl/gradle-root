package org.github.spring.restful.file;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import javax.annotation.Nullable;
import lombok.*;
import org.github.exception.ExternalException;
import org.github.exception.InternalException;
import org.github.spring.restful.Returnable;
import org.springframework.core.io.Resource;
import com.google.common.net.MediaType;
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
  @NonNull
  default MediaType mediaType() {
    return OCTET_STREAM;
  }

  /**
   * Generator.
   */
  @NonNull
  static FILE of(@NonNull File file) {
    return of(file, null);
  }

  /**
   * Generator.
   */
  @NonNull
  static FILE of(@NonNull File file, @Nullable MediaType type) {
    try {
      return new FILEImpl(file.getName(), new FileInputStream(file), type);
    } catch (FileNotFoundException e) {
      throw new ExternalException(format("文件[%s]不存在", file.getName()), e);
    }
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

  /**
   * Generator.
   */
  @NonNull
  static FILE of(@NonNull Resource resource) {
    return of(resource, null);
  }

  /**
   * Generator.
   */
  @NonNull
  static FILE of(@NonNull Resource resource, @Nullable MediaType type) {
    val name = requireNonNull(resource.getFilename());
    try {
      return new FILEImpl(name, resource.getInputStream(), type);
    } catch (FileNotFoundException e) {
      throw new ExternalException(format("文件[%s]不存在", name), e);
    } catch (IOException e) {
      throw new InternalException(format("文件[%s]内容读取失败", name), e);
    }
  }
}
