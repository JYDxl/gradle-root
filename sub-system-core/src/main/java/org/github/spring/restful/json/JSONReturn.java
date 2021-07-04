package org.github.spring.restful.json;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.*;
import org.github.exception.RemoteErrorException;
import org.github.spring.restful.ops.Result;
import com.fasterxml.jackson.annotation.JsonIgnore;
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
  /** HTTP状态码. */
  @JsonIgnore
  private          int    status;
  /** 返回的信息. */
  private @NonNull String retMsg;

  public JSONReturn() {
    this(SUCCESS.getCode(), SUCCESS.getMsg(), SUCCESS.getStatus().value());
  }

  private JSONReturn(int retCode, @NonNull String retMsg, int status) {
    this.retCode = retCode;
    this.retMsg  = retMsg;
    this.status  = status;
  }

  @Override
  public void collect(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) throws Exception {
    res.setStatus(status);
    JSON.super.collect(req, res);
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

  @Deprecated
  public void setRetCode(int retCode) {
    this.retCode = retCode;
  }

  @Deprecated
  public void setStatus(int status) {
    this.status = status;
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
    return new JSONReturn(result.getCode(), result.getMsg(), result.getStatus().value());
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
