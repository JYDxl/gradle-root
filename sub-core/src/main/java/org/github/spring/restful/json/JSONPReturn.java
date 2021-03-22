package org.github.spring.restful.json;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import lombok.*;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.net.MediaType;

import static com.google.common.base.MoreObjects.*;
import static com.google.common.net.MediaType.*;
import static org.github.spring.footstone.IConstKt.*;

/**
 * JSON of jsonp.
 *
 * @param <T> data
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 * @see org.github.spring.restful.json.JSON
 * @see JSONReturn
 * @see JSONDataReturn
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class JSONPReturn<T> extends JSONDataReturn<T> implements JSON {
  /** callback. */
  @JsonIgnore
  @NonNull
  private String callback = CALL_BACK;

  @Override
  public void collect(@Nonnull HttpServletRequest req, @Nonnull HttpServletResponse res) throws Exception {
    if(CALL_BACK.equals(callback)) setCallback(firstNonNull(req.getParameter(CALL_BACK), CALL_BACK));
    super.collect(req, res);
  }

  @Override
  @Nonnull
  public String get() {
    return callback + "(" + super.get() + ")";
  }

  @Override
  public boolean functional() {
    return true;
  }

  @Override
  public String toString() {
    return super.get();
  }

  @Override
  @Nonnull
  public MediaType mediaType() {
    return JAVASCRIPT_UTF_8;
  }

  /** WITH callback. */
  public JSONPReturn<T> withCallback(@Nonnull String callback) {
    setCallback(callback);
    return this;
  }

  /** Generator. */
  @Nonnull
  public static JSONPReturn<?> of() {
    return new JSONPReturn<>();
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @Nonnull
  public static <V> JSONPReturn<V> of(V data) {
    return (JSONPReturn) new JSONPReturn<>().withData(data);
  }
}
