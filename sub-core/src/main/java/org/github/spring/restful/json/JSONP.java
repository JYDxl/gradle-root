package org.github.spring.restful.json;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
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
 * @see org.github.spring.restful.json.JSONBasic
 * @see org.github.spring.restful.json.JSONData
 */
@EqualsAndHashCode(callSuper = true)
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JSONP<T> extends JSONData<T> implements JSON {
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
  @Nonnull
  public MediaType mediaType() {
    return JAVASCRIPT_UTF_8;
  }

  @Override
  public String toString() {
    return super.get();
  }

  @Override
  public void release() {
    callback = CALL_BACK;
    super.release();
  }

  /** WITH callback. */
  public JSONP<T> withCallback(@Nonnull String callback) {
    setCallback(callback);
    return this;
  }

  /** Generator. */
  @Nonnull
  public static JSONP<?> of() {
    return new JSONP<>();
  }

  /** Generator. */
  @SuppressWarnings({"unchecked", "rawtypes"})
  @Nonnull
  public static <V> JSONP<V> of(V data) {
    return (JSONP) new JSONP<>().withData(data);
  }
}
