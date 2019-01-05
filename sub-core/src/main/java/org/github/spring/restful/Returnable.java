package org.github.spring.restful;

import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.github.spring.enumeration.ContentType;

import org.jetbrains.annotations.NotNull;

import static java.nio.charset.StandardCharsets.UTF_8;
import static org.github.spring.enumeration.ContentType.TEXT;
import static org.github.spring.footstone.IConstKt.EMPTY;

/**
 * Top interface of all.
 *
 * 1.该接口的核心方法为{@link Returnable#get}.
 * 2.该接口默认返回字符串{@code text/plain; charset=UTF-8}.
 * 3.该接口为函数接口{@link FunctionalInterface}.
 *
 * <pre>
 *     return Returnable.of();
 * </pre>
 *
 * @author JYD_XL
 * @see Serializable
 */
@FunctionalInterface
public interface Returnable extends Serializable {
  /** 通过字符流{@link Writer}处理数据. */
  @Deprecated
  default void accept(@NotNull Writer writer) throws Exception {
    writer.write(get());
  }

  /** 通过字节流{@link OutputStream}处理数据. */
  @Deprecated
  default void accept(@NotNull OutputStream output) throws Exception {
    throw new UnsupportedOperationException();
  }

  /** 通过请求{@link HttpServletRequest}和响应{@link HttpServletResponse}处理数据. */
  @Deprecated
  default void collect(@NotNull HttpServletRequest request, @NotNull HttpServletResponse response) throws Exception {
    response.setContentType(contentType().get());
    response.setCharacterEncoding(UTF_8.name());
    if (functional()) {
      accept(response.getWriter());
    } else {
      accept(response.getOutputStream());
    }
  }

  /** 获取返回类型. */
  @Deprecated
  @NotNull
  default ContentType contentType() {
    return TEXT;
  }

  /** 直接通过函数接口传递数据? */
  @Deprecated
  default boolean functional() {
    return true;
  }

  /** 获取数据. */
  @NotNull
  String get() throws Exception;

  /** 清空数据. */
  @Deprecated
  default void release() {
    // 接口没有状态, 直接通过函数接口传递的数据无法保存, 因而无法执行清理操作, 此处的默认实现为空...
  }

  /** 请求已被完全处理? 未处理完毕的请求将交由Spring继续处理.(现阶段只对视图有效.) */
  @Deprecated
  default boolean terminal() {
    return true;
  }

  /** Generator. */
  @NotNull
  static Returnable of(@NotNull Returnable data) {
    return data;
  }

  /** Generator. */
  @NotNull
  @SuppressWarnings("NullableProblems")
  static Returnable of(@NotNull Object data) {
    return data::toString;
  }

  /** Generator. */
  @NotNull
  static Returnable of() {
    return of(EMPTY);
  }
}
