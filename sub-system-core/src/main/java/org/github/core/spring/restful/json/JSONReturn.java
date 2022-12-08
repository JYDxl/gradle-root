package org.github.core.spring.restful.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.*;
import org.github.core.spring.restful.Returnable;
import org.github.core.exception.RemoteException;
import org.github.core.spring.restful.ops.Result;
import static cn.hutool.core.text.CharSequenceUtil.*;
import static org.github.core.spring.ops.SpringKt.json;
import static org.github.core.spring.restful.ops.Result.*;

/**
 * JSON of basic.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see Returnable
 * @see JSON
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

  @Override
  public void handle(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) throws Exception {
    res.setContentType(mediaType().toString());
    org.github.core.spring.ops.SpringKt.writeValue(this, res.getOutputStream());
  }

  @Override
  @NonNull
  public String get() {
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
  @NonNull
  public JSONReturn withMsg(@NonNull String msg) {
    setMsg(msg);
    return this;
  }

  /** Generator. */
  @NonNull
  public
  static JSONReturn internal(String msg) {
    return of(SYSTEM_ERROR, msg);
  }

  /** Generator. */
  @NonNull
  public
  static JSONReturn of(Result result, String msg) {
    return new JSONReturn(result.getCode(), firstNonBlank(msg, result.getMsg()));
  }

  /** Generator. */
  @NonNull
  public
  static JSONReturn ok() {
    return of(SUCCESS, null);
  }

  /** Generator. */
  @NonNull
  public
  static JSONReturn external(String msg) {
    return of(PARAMS_ERROR, msg);
  }

  /** Generator. */
  @NonNull
  public
  static JSONReturn auth(String msg) {
    return of(AUTH_ERROR, msg);
  }

  /** Generator. */
  @NonNull
  public
  static JSONReturn perm(String msg) {
    return of(PERM_ERROR, msg);
  }

  /** Generator. */
  @NonNull
  public
  static JSONReturn call(String msg) {
    return of(CALL_ERROR, msg);
  }
}
