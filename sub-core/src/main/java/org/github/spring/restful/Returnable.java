package org.github.spring.restful;

import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.nio.charset.StandardCharsets;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.github.spring.enumerate.ContentType;
import org.github.spring.footstone.IConstKt;
import com.google.common.base.MoreObjects;

/**
 * 可返回类型顶层接口.
 *
 * @author JYD_XL
 * @since 2019-01-29
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 */
@FunctionalInterface //TODO 待整理, 包括各实现类
public interface Returnable extends Serializable, Supplier<String> {
  /** 通过字符流{@link Writer}处理数据. */
  @Deprecated
  default void accept(@Nonnull Writer writer) throws Exception {
    writer.write(MoreObjects.firstNonNull(get(), IConstKt.NULL));
  }

  /** 通过字节流{@link OutputStream}处理数据. */
  @Deprecated
  default void accept(@Nonnull OutputStream output) throws Exception {
    throw new Exception();
  }

  /** 通过请求{@link HttpServletRequest}和响应{@link HttpServletResponse}处理数据. */
  @Deprecated
  default void collect(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response) throws Exception {
    response.setContentType(contentType().get());
    response.setCharacterEncoding(StandardCharsets.UTF_8.name());
    if (functional()) {
      accept(response.getWriter());
    } else {
      accept(response.getOutputStream());
    }
  }

  /** 获取返回类型. */
  @Deprecated
  @Nonnull
  default ContentType contentType() {
    return ContentType.TEXT;
  }

  /** 直接通过函数接口传递数据? */
  @Deprecated
  default boolean functional() {
    return true;
  }

  /** 获取数据. */
  @Override
  @Nullable
  String get();

  /** 清空数据. */
  default void release() {}

  /** 请求已被完全处理? 未处理完毕的请求将交由Spring继续处理.(现阶段只对视图有效.) */
  @Deprecated
  default boolean terminal() {
    return true;
  }

  /** Generator. */
  @Nonnull
  static Returnable of(@Nonnull Returnable data) {
    return data;
  }

  /** Generator. */
  @Nonnull
  static Returnable of(@Nonnull Object data) {
    return data::toString;
  }

  /** Generator. */
  @Nonnull
  static Returnable of() {
    return of(IConstKt.EMPTY);
  }
}
