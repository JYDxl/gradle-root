package org.github.spring.restful;

import java.io.OutputStream;
import java.io.Serializable;
import java.io.Writer;
import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.github.spring.enumeration.ContentType;
import static java.nio.charset.StandardCharsets.UTF_8;
import static org.github.spring.enumeration.ContentType.TEXT;
import static org.github.spring.footstone.IConstKt.EMPTY;

/**
 * Top interface of all.
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
  default void accept(@Nonnull Writer writer) throws Exception {
    writer.write(get());
  }

  /** 通过字节流{@link OutputStream}处理数据. */
  @Deprecated
  default void accept(@Nonnull OutputStream output) throws Exception {
    throw new UnsupportedOperationException();
  }

  /** 通过请求{@link HttpServletRequest}和响应{@link HttpServletResponse}处理数据. */
  @Deprecated
  default void collect(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response) throws Exception {
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
  @Nonnull
  default ContentType contentType() {
    return TEXT;
  }

  /** 直接通过函数接口传递数据? */
  @Deprecated
  default boolean functional() {
    return true;
  }

  /** 获取数据. */
  @Nonnull
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
  @Nonnull
  static Returnable of(@Nonnull Returnable data) {
    return data;
  }

  /** Generator. */
  @Nonnull
  @SuppressWarnings("NullableProblems")
  static Returnable of(@Nonnull Object data) {
    return data::toString;
  }

  /** Generator. */
  @Nonnull
  static Returnable of() {
    return of(EMPTY);
  }
}
