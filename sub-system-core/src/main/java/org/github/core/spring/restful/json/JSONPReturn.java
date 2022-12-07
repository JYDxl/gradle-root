package org.github.core.spring.restful.json;

import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.net.MediaType;
import org.github.core.spring.restful.Returnable;

import static cn.hutool.extra.servlet.ServletUtil.*;
import static com.google.common.base.MoreObjects.*;
import static com.google.common.net.MediaType.*;
import static java.util.Optional.*;

/**
 * JSON of jsonp.
 *
 * @param <T> data
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see Returnable
 * @see JSON
 * @see JSONReturn
 * @see JSONDataReturn
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JSONPReturn<T> extends JSONDataReturn<T> implements JSON {
  /** 回调 */
  @JsonIgnore
  private @NonNull String callback = "callback";

  @Override
  public void handle(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) {
    if ("callback".equals(callback)) setCallback(firstNonNull(req.getParameter("callback"), "callback"));
    write(res, get(), mediaType().toString());
  }

  @Override
  @NonNull
  public MediaType mediaType() {
    return JAVASCRIPT_UTF_8;
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
    return of(ofNullable(data).map(mapper).orElse(null));
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @NonNull
  public static <V> JSONPReturn<V> of(V data) {
    return (JSONPReturn) new JSONPReturn<>().withData(data);
  }
}
