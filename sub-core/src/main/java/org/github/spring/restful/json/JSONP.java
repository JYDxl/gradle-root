package org.github.spring.restful.json;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.github.spring.enumerate.ContentType;
import org.github.spring.footstone.IConstKt;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.google.common.base.MoreObjects;

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
  private String callback = IConstKt.CALL_BACK;

  @Override
  public void collect(@Nonnull HttpServletRequest req, @Nonnull HttpServletResponse resp) throws Exception {
    if(IConstKt.CALL_BACK.equals(callback)) setCallback(MoreObjects.firstNonNull(req.getParameter(IConstKt.CALL_BACK), IConstKt.CALL_BACK));
    super.collect(req, resp);
  }

  @Override
  @Nonnull
  public String get() {
    return callback + "(" + super.get() + ")";
  }

  @Override
  public boolean isFunctional() {
    return true;
  }

  @Override
  @Nonnull
  public ContentType getContentType() {
    return ContentType.JSONP;
  }

  @Override
  public void release() {
    callback = IConstKt.CALL_BACK;
    super.release();
  }

  @Override
  public String toString() {
    return super.get();
  }

  /** WITH callback. */
  public JSONP<T> withCallback(@Nonnull String callback) {
    setCallback(callback);
    return this;
  }

  /** Generator. */
  @Nonnull
  public static JSONP of() {
    return new JSONP();
  }

  /** Generator. */
  @SuppressWarnings("unchecked")
  @Nonnull
  public static <V> JSONP<V> of(V data) {
    return (JSONP) new JSONP<>().withData(data);
  }
}
