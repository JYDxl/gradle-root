package org.github.spring.restful;

import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import java.util.function.Supplier;
import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.github.spring.enumerate.ContentType;
import org.github.spring.footstone.IConstKt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;

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
  @Override
  @Nullable
  String get();

  /** 通过字符流{@link Writer}处理数据. */
  default void accept(@Nonnull Writer writer) throws Exception {
    writer.write(MoreObjects.firstNonNull(get(), IConstKt.NULL));
  }

  /** 通过字节流{@link OutputStream}处理数据. */
  default void accept(@Nonnull OutputStream output) throws Exception {
    throw new Exception("unsupported");
  }

  /** 通过请求{@link HttpServletRequest}和响应{@link HttpServletResponse}处理数据. */
  default void collect(@Nonnull HttpServletRequest req, @Nonnull HttpServletResponse resp) throws Exception {
    resp.setContentType(getContentType().toString());
    if(isFunctional()) {
      accept(resp.getWriter());
    } else {
      accept(resp.getOutputStream());
    }
  }

  /** 获取返回类型. */
  @JsonIgnore
  @Nonnull
  default ContentType getContentType() {
    return ContentType.TEXT;
  }

  /** 直接通过函数接口传递数据? */
  @JsonIgnore
  default boolean isFunctional() {
    return true;
  }

  /** 数据已被完全处理? 未处理完毕的数据将交由Spring继续处理(现阶段只对视图有效). */
  @JsonIgnore
  default boolean isTerminated() {
    return true;
  }

  /** 清空数据. */
  default void release() {}

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

  /** Generator. */
  @Nonnull
  static Returnable nil() {
    return IConstKt.getRestNil();
  }
}
