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
import org.jetbrains.annotations.Contract;
import com.fasterxml.jackson.annotation.JsonIgnore;

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
    if (IConstKt.CALL_BACK.equals(callback)) setCallback(req.getParameter(IConstKt.CALL_BACK));
    super.collect(req, resp);
  }

  @Override
  @Nonnull
  public ContentType contentType() {
    return ContentType.JSONP;
  }

  @Override
  @Nonnull
  public String get() {
    return IConstKt.getEmptyJoiner().join(callback, "(", super.get(), ")");
  }

  @Override
  public boolean functional() {
    return true;
  }

  @Override
  public void release() {
    callback = IConstKt.CALL_BACK;
    super.release();
  }

  @Override
  public String toString() {
    return super.toString();
  }

  /** WITH callback. */
  public JSONP<T> withCallback(@Nonnull String callback) {
    setCallback(callback);
    return this;
  }

  /** Generator. */
  @Contract(" -> new")
  @Nonnull
  public static JSONP of() {
    return new JSONP();
  }

  /** Generator. */
  @Nonnull
  public static <V> JSONP<V> of(V data) {
    return (JSONP<V>) new JSONP<>().withData(data);
  }
}
