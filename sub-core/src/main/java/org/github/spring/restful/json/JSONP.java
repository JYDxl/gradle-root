package org.github.spring.restful.json;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.github.spring.enumeration.ContentType;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import static org.github.spring.enumeration.ContentType.JSONP;
import static org.github.spring.footstone.IConstKt.CALL_BACK;
import static org.github.spring.footstone.IConstKt.getJOINER_EMPTY;
import static org.github.spring.footstone.IConstKt.getPARAM_PATTERN;

/**
 * JSON_ENCODER of jsonp.
 *
 * <pre>
 *   return JSONP.of();
 * </pre>
 *
 * @param <T> data
 * @author JYD_XL
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 * @see org.github.spring.restful.json.JSON
 * @see org.github.spring.footstone.AbstractEntity
 * @see org.github.spring.restful.json.JSONBasic
 * @see org.github.spring.restful.json.JSONData
 */
@JsonIgnoreProperties("callback")
@SuppressWarnings("ALL")
public class JSONP<T> extends JSONData<T> implements JSON {
  /** callback. */
  private String callback = CALL_BACK;

  /** Constructor. */
  public JSONP() {}

  /** Constructor. */
  public JSONP(T data) {
    this.withData(data);
  }

  /** Constructor. */
  public JSONP(@Nonnull String callback, T data) {
    this.withCallback(callback).withData(data);
  }

  @Deprecated
  @Override
  public void collect(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response) throws Exception {
    if (CALL_BACK.equals(callback)) setCallback(request.getParameter(CALL_BACK));
    super.collect(request, response);
  }

  @Deprecated
  @Override
  public boolean functional() {
    return true;
  }

  @Override
  @Nonnull
  public String get() {
    return getJOINER_EMPTY().join(callback, "(", super.get(), ")");
  }

  @Deprecated
  @Override
  @Nonnull
  public ContentType contentType() {
    return JSONP;
  }

  @Override
  public void release() {
    callback = CALL_BACK;
    super.release();
  }

  /** GET callback. */
  public String getCallback() {
    return callback;
  }

  /** SET callback. */
  public void setCallback(@Nonnull String callback) {
    if (getPARAM_PATTERN().matcher(callback).matches()) this.callback = callback;
  }

  /** WITH callback. */
  public org.github.spring.restful.json.JSONP<T> withCallback(@Nonnull String callback) {
    this.setCallback(callback);
    return this;
  }

  /** Generator. */
  public static org.github.spring.restful.json.JSONP of() {
    return new JSONP();
  }

  /** Generator. */
  public static <V> org.github.spring.restful.json.JSONP<V> of(V data) {
    return new JSONP<>(data);
  }

  /** Generator. */
  @SafeVarargs
  public static <V> org.github.spring.restful.json.JSONP<V[]> of(V... data) {
    return new JSONP<>(data);
  }
}
