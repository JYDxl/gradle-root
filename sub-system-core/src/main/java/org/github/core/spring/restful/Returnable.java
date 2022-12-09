package org.github.core.spring.restful;

import java.io.Serializable;
import java.util.function.Supplier;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.*;
import com.google.common.net.MediaType;
import static cn.hutool.extra.servlet.ServletUtil.*;
import static com.google.common.net.MediaType.*;

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
  default void handle(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) throws Exception {
    write(res, get(), mediaType().toString());
  }

  /** 获取数据. */
  @Override
  @Nullable
  String get();

  /** 获取返回类型. */
  @NonNull
  default MediaType mediaType() {
    return PLAIN_TEXT_UTF_8;
  }

  /** 数据已被完全处理? 未处理完毕的数据将交由Spring继续处理(现阶段只对视图有效). */
  default boolean terminated() {
    return true;
  }

  /** Generator. */
  @NonNull
  static Returnable of() {
    return of("");
  }

  /** Generator. */
  @NonNull
  static Returnable of(@NonNull Object data) {
    return data::toString;
  }

  /** Generator. */
  @NonNull
  static Returnable nil() {
    return () -> null;
  }
}
