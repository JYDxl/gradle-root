package org.github.spring.restful.json;

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
  /** 返回的状态. */
  private          int    retCode;
  /** 返回的信息. */
  private @NonNull String retMsg;

  public JSONReturn() {
    this(SUCCESS.getCode(), SUCCESS.getMsg());
  }

  private JSONReturn(int retCode, @NonNull String retMsg) {
    this.retCode = retCode;
    this.retMsg  = retMsg;
  }

  @Override
  public boolean functional() {
    return false;
  }

  @Override
  public @NonNull String get() {
    return json(this);
  }

  @Override
  public String toString() {
    return get();
  }

  public void setRetCode(int retCode) {
    this.retCode = retCode;
  }

  public void throwIfFailed() throws RemoteException {
    if (failure()) throw new RemoteException(this);
  }

  public boolean failure() {
    return !success();
  }

  public boolean success() {
    return retCode == SUCCESS.getCode();
  }

  /** WITH retMsg. */
  public @NonNull JSONReturn withRetMsg(@NonNull String retMsg) {
    setRetMsg(retMsg);
    return this;
  }

  /** Generator. */
  public static @NonNull JSONReturn error(String msg) {
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
  public static @NonNull JSONReturn param(String msg) {
    return of(PARAMS_ERROR, msg);
  }

  /** Generator. */
  public static @NonNull JSONReturn path(String msg) {
    return of(PATH_ERROR, msg);
  }

  /** Generator. */
  public static @NonNull JSONReturn auth(String msg) {
    return of(AUTH_ERROR, msg);
  }
}
