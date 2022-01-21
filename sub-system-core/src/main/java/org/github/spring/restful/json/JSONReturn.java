package org.github.spring.restful.json;

import lombok.*;
import org.github.exception.RemoteErrorException;
import org.github.spring.restful.ops.Result;
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

  public void throwIfFailed() throws RemoteErrorException {
    if (failure()) throw new RemoteErrorException(this);
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
  public static @NonNull JSONReturn error() {
    return of(SYSTEM_ERROR);
  }

  /** Generator. */
  public static @NonNull JSONReturn of(Result result) {
    return new JSONReturn(result.getCode(), result.getMsg());
  }

  /** Generator. */
  public static @NonNull JSONReturn ok() {
    return of(SUCCESS);
  }

  /** Generator. */
  public static @NonNull JSONReturn param() {
    return of(PARAMS_ERROR);
  }

  /** Generator. */
  public static @NonNull JSONReturn path() {
    return of(PATH_ERROR);
  }

  /** Generator. */
  public static @NonNull JSONReturn auth() {
    return of(AUTH_ERROR);
  }
}
