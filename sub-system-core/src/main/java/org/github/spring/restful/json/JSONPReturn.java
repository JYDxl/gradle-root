package org.github.spring.restful.json;

import java.io.OutputStream;
import java.util.function.Function;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.net.MediaType;
import static com.google.common.net.MediaType.*;
import static java.util.Optional.*;
import static org.github.util.ObjUtil.*;

/**
 * JSON of jsonp.
 *
 * @param <T> data
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 * @see org.github.spring.restful.json.JSON
 * @see org.github.spring.restful.json.JSONReturn
 * @see org.github.spring.restful.json.JSONDataReturn
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JSONPReturn<T> extends JSONDataReturn<T> implements JSON {
  /** callback. */
  @JsonIgnore
  private @NonNull String callback = "callback";

  @Override
  public void collect(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) throws Exception {
    if ("callback".equals(callback)) setCallback(firstNonNull(req.getParameter("callback"), "callback"));
    super.collect(req, res);
  }

  @Override
  public boolean functional() {
    return true;
  }

  @Override
  public @NonNull String get() {
    return callback + "(" + super.get() + ")";
  }

  @Override
  public @NonNull MediaType mediaType() {
    return JAVASCRIPT_UTF_8;
  }

  @Override
  public void accept(@NonNull OutputStream output) {
    throw new UnsupportedOperationException();
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
  public static <V> @NonNull JSONPReturn<V> of() {
    return new JSONPReturn<>();
  }

  /** Generator. */
  public static <T, R extends T> @NonNull JSONPReturn<R> of(T data, @NonNull Function<T,R> mapper) {
    return of(ofNullable(data).map(mapper).orElse(null));
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  public static <V> @NonNull JSONPReturn<V> of(V data) {
    return (JSONPReturn) new JSONPReturn<>().withData(data);
  }
}
