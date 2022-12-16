package org.github.core.spring.restful.json;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.net.MediaType;
import io.swagger.annotations.ApiModelProperty;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import org.jetbrains.annotations.NotNull;
import static cn.hutool.core.text.CharSequenceUtil.firstNonBlank;
import static cn.hutool.extra.servlet.ServletUtil.write;
import static com.google.common.net.MediaType.JAVASCRIPT_UTF_8;
import static java.util.Optional.ofNullable;

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
public class JSONP<T> extends JSONData<T> implements JSON {
  @ApiModelProperty("回调函数")
  @JsonIgnore
  @NotNull
  private String callback = "callback";

  @Override
  public void handle(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) {
    if ("callback".equals(callback)) setCallback(firstNonBlank(req.getParameter("callback"), "callback"));
    write(res, get(), mediaType().toString());
  }

  @Override
  @NotNull
  public MediaType mediaType() {
    return JAVASCRIPT_UTF_8;
  }

  @Override
  @NotNull
  public String get() {
    return callback + "(" + super.get() + ")";
  }

  @Override
  public String toString() {
    return super.get();
  }

  /** WITH callback. */
  public JSONP<T> withCallback(@NotNull String callback) {
    setCallback(callback);
    return this;
  }

  /** Generator. */
  @NotNull
  public static <V> JSONP<V> of() {
    return new JSONP<>();
  }

  /** Generator. */
  @NotNull
  public static <T, R extends T> JSONP<R> of(T data, @NotNull Function<T,R> mapper) {
    return of(ofNullable(data).map(mapper).orElse(null));
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @NotNull
  public static <V> JSONP<V> of(V data) {
    return (JSONP) new JSONP<>().withData(data);
  }
}
