package org.github.spring.restful.json;

import lombok.*;
import org.github.exception.RemoteErrorException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import static org.github.spring.ops.SpringKt.*;
import static org.springframework.http.HttpStatus.OK;

/**
 * JSON of basic.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 * @see org.github.spring.restful.Returnable
 * @see org.github.spring.restful.json.JSON
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
public class JSONReturn implements JSON {
  /** 返回的状态码. */
  private          int    retCode = OK.value();
  /** 返回的信息. */
  private @NonNull String retMsg  = OK.getReasonPhrase();

  @Override
  public void collect(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) throws Exception {
    res.setStatus(retCode);
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

  public void throwIfFailed() throws RemoteErrorException {
    if (failure()) throw new RemoteErrorException(this);
  }

  public boolean failure() {
    return !success();
  }

  public boolean success() {
    return retCode == OK.value();
  }

  /** WITH retCode. */
  public @NonNull JSONReturn withRetCode(int retCode) {
    setRetCode(retCode);
    return this;
  }

  /** WITH retMsg. */
  public @NonNull JSONReturn withRetMsg(@NonNull String retMsg) {
    setRetMsg(retMsg);
    return this;
  }

  /** Generator. */
  public static @NonNull JSONReturn error() {
    return of(CODE_SYSTEM_ERROR, "系统错误");
  }

  /** Generator. */
  public static @NonNull JSONReturn of(int code, @NonNull String msg) {
    return new JSONReturn(code, msg);
  }

  /** Generator. */
  public static @NonNull JSONReturn warn() {
    return of(CODE_PARAMS_ERROR, "参数错误");
  }

  /** Generator. */
  public static @NonNull JSONReturn path() {
    return of(CODE_404_ERROR, "路径错误");
  }

  /** Generator. */
  public static @NonNull JSONReturn auth() {
    return of(CODE_AUTH_ERROR, "权限错误");
  }
}