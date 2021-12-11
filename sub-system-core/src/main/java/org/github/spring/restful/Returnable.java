package org.github.spring.restful;

import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.*;
import com.google.common.net.MediaType;
import static com.google.common.net.MediaType.*;
import static org.github.util.ObjUtil.*;

/**
 * Top interface of all.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 */
@FunctionalInterface
public interface Returnable extends Serializable, Supplier<String> {
  /** 通过请求{@link HttpServletRequest}和响应{@link HttpServletResponse}处理数据. */
  default void collect(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) throws Exception {
    res.setContentType(mediaType().toString());
    if (functional()) {
      accept(res.getWriter());
    } else {
      accept(res.getOutputStream());
    }
  }

  /** 获取返回类型. */
  default @NonNull MediaType mediaType() {
    return PLAIN_TEXT_UTF_8;
  }

  /** 直接通过函数接口传递数据? */
  default boolean functional() {
    return true;
  }

  /** 通过字符流{@link Writer}处理数据. */
  default void accept(@NonNull Writer writer) throws Exception {
    writer.write(firstNonNull(get(), "null"));
  }

  /** 通过字节流{@link OutputStream}处理数据. */
  default void accept(@NonNull OutputStream output) throws Exception {
    throw new UnsupportedOperationException();
  }

  /** 获取数据. */
  @Override
  @Nullable String get();

  /** 数据已被完全处理? 未处理完毕的数据将交由Spring继续处理(现阶段只对视图有效). */
  default boolean terminated() {
    return true;
  }

  /** Generator. */
  static @NonNull Returnable of() {
    return of("");
  }

  /** Generator. */
  static @NonNull Returnable of(@NonNull Object data) {
    return data::toString;
  }

  /** Generator. */
  static @NonNull Returnable nil() {
    return () -> null;
  }
}
