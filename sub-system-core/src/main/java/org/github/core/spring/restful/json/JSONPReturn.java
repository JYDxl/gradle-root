package org.github.core.spring.restful.json;

import cn.hutool.core.util.StrUtil;
import cn.hutool.extra.servlet.ServletUtil;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.net.MediaType;
import java.util.Optional;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;

/**
 * JSON of jsonp.
 *
 * @param <T> data
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JSONPReturn<T> extends JSONDataReturn<T> implements JSON {
  /** 回调 */
  @JsonIgnore private @NonNull String callback = "callback";

  @Override
  public void handle(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) {
    if ("callback".equals(callback)) setCallback(StrUtil.firstNonBlank(req.getParameter("callback"), "callback"));
    ServletUtil.write(res, get(), mediaType().toString());
  }

  @Override
  @NonNull
  public MediaType mediaType() {
    return MediaType.JAVASCRIPT_UTF_8;
  }

  @Override
  @NonNull
  public String get() {
    return callback + "(" + super.get() + ")";
  }

  @Override
  public String toString() {
    return super.get();
  }

  /** WITH callback. */
  public JSONPReturn<T> withCallback(@NonNull String callback) {
    setCallback(callback);
    return this;
  }

  /** Generator. */
  @NonNull
  public static <V> JSONPReturn<V> of() {
    return new JSONPReturn<>();
  }

  /** Generator. */
  @NonNull
  public static <T, R extends T> JSONPReturn<R> of(T data, @NonNull Function<T,R> mapper) {
    return of(Optional.ofNullable(data).map(mapper).orElse(null));
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @NonNull
  public static <V> JSONPReturn<V> of(V data) {
    return (JSONPReturn) new JSONPReturn<>().withData(data);
  }
}
