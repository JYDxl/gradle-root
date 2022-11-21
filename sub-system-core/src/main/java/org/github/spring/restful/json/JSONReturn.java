package org.github.spring.restful.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.*;
import org.github.exception.RemoteException;
import org.github.spring.restful.ops.Result;
import static cn.hutool.core.text.CharSequenceUtil.*;
import static org.github.spring.ops.SpringKt.*;
import static org.github.spring.restful.ops.Result.*;

/**
 * JSON of basic.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 * @see org.github.spring.restful.json.JSON
 */
@Data
public class JSONReturn implements JSON {
  /** 状态 */
  private          int    code;
  /** 信息 */
  private @NonNull String msg;

  public JSONReturn() {
    this(SUCCESS.getCode(), SUCCESS.getMsg());
  }

  private JSONReturn(int code, @NonNull String msg) {
    this.code = code;
    this.msg  = msg;
  }

  @Override public void collect(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) throws Exception {
    res.setContentType(mediaType().toString());
    writeValue(this, res.getOutputStream());
  }

  @Override
  public @NonNull String get() {
    return json(this);
  }

  @Override
  public String toString() {
    return get();
  }

  public void setCode(int code) {
    this.code = code;
  }

  public void throwIfFailed() throws RemoteException {
    if (failure()) throw new RemoteException(this);
  }

  public boolean failure() {
    return !success();
  }

  public boolean success() {
    return code == SUCCESS.getCode();
  }

  /** WITH msg. */
  public @NonNull JSONReturn withMsg(@NonNull String msg) {
    setMsg(msg);
    return this;
  }

  /** Generator. */
  public static @NonNull JSONReturn internal(String msg) {
    return of(SYSTEM_ERROR, msg);
  }

  /** Generator. */
  public static @NonNull JSONReturn of(Result result, String msg) {
    return new JSONReturn(result.getCode(), firstNonBlank(msg, result.getMsg()));
  }

  /** Generator. */
  public static @NonNull JSONReturn ok() {
    return of(SUCCESS, null);
  }

  /** Generator. */
  public static @NonNull JSONReturn external(String msg) {
    return of(PARAMS_ERROR, msg);
  }

  /** Generator. */
  public static @NonNull JSONReturn auth(String msg) {
    return of(AUTH_ERROR, msg);
  }

  /** Generator. */
  public static @NonNull JSONReturn perm(String msg) {
    return of(PERM_ERROR, msg);
  }

  /** Generator. */
  public static @NonNull JSONReturn call(String msg) {
    return of(CALL_ERROR, msg);
  }
}
