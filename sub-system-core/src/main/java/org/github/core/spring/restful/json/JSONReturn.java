package org.github.core.spring.restful.json;

import cn.hutool.core.util.StrUtil;
import com.google.common.base.MoreObjects;
import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Data;
import lombok.NonNull;
import org.github.core.exception.RemoteException;
import org.github.core.spring.ops.SpringKt;
import org.springframework.http.HttpStatus;

/**
 * JSON of basic.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 */
@Data
public class JSONReturn implements JSON {
  /** 状态 */
  private          int    code;
  /** 信息 */
  private @NonNull String msg;

  public JSONReturn() {
    this(HttpStatus.OK.value(), HttpStatus.OK.name());
  }

  private JSONReturn(int code, @NonNull String msg) {
    this.code = code;
    this.msg  = msg;
  }

  @Override
  public void handle(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) throws Exception {
    res.setContentType(mediaType().toString());
    SpringKt.writeValue(this, res.getOutputStream());
  }

  @Override
  @NonNull
  public String get() {
    return SpringKt.json(this);
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
    return code == HttpStatus.OK.value();
  }

  /** WITH msg. */
  @NonNull
  public JSONReturn withMsg(@NonNull String msg) {
    setMsg(msg);
    return this;
  }

  /** Generator. */
  @NonNull
  public static JSONReturn ok() {
    return of(HttpStatus.OK, null);
  }

  /** Generator. */
  @NonNull
  public static JSONReturn of(HttpStatus status, @Nullable String msg) {
    return of(status.value(), StrUtil.firstNonBlank(msg, status.name()));
  }

  @NonNull
  public static JSONReturn of(int code, @Nullable String msg) {
    return new JSONReturn(code, MoreObjects.firstNonNull(msg, ""));
  }
}
