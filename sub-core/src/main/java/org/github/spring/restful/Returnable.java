package org.github.spring.restful;

import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.common.net.MediaType;

import static com.google.common.base.MoreObjects.*;
import static com.google.common.net.MediaType.*;
import static org.github.spring.footstone.IConstKt.*;

/**
 * Top interface of all.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 */
@FunctionalInterface
public interface Returnable extends Serializable, Supplier<String> {
  /** 获取数据. */
  @Nullable
  @Override
  String get();

  /** 通过字符流{@link Writer}处理数据. */
  default void accept(@Nonnull Writer writer) throws Exception {
    writer.write(firstNonNull(get(), NULL));
  }

  /** 通过字节流{@link OutputStream}处理数据. */
  default void accept(@Nonnull OutputStream output) throws Exception {
    throw new UnsupportedOperationException();
  }

  /** 通过请求{@link HttpServletRequest}和响应{@link HttpServletResponse}处理数据. */
  default void collect(@Nonnull HttpServletRequest req, @Nonnull HttpServletResponse res) throws Exception {
    res.setContentType(mediaType().toString());
    if(functional()) {
      accept(res.getWriter());
    } else {
      accept(res.getOutputStream());
    }
  }

  /** 直接通过函数接口传递数据? */
  default boolean functional() {
    return true;
  }

  /** 获取返回类型. */
  @Nonnull
  default MediaType mediaType() {
    return PLAIN_TEXT_UTF_8;
  }

  /** 数据已被完全处理? 未处理完毕的数据将交由Spring继续处理(现阶段只对视图有效). */
  default boolean terminated() {
    return true;
  }

  /** Generator. */
  @Nonnull
  static Returnable of(@Nonnull Object data) {
    return data::toString;
  }

  /** Generator. */
  @Nonnull
  static Returnable of() {
    return () -> EMPTY;
  }

  /** Generator. */
  @Nonnull
  static Returnable nil() {
    return () -> null;
  }
}
