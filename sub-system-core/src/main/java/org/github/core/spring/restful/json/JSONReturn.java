package org.github.core.spring.restful.json;

import javax.annotation.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.*;
import org.github.core.exception.RemoteException;
import org.github.core.spring.restful.Returnable;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import static cn.hutool.core.text.CharSequenceUtil.*;
import static org.github.core.spring.ops.SpringKt.*;
import static org.springframework.http.HttpStatus.*;

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
    this(OK.value(), OK.name());
  }

  private JSONReturn(int code, @NonNull String msg) {
    this.code = code;
    this.msg  = msg;
  }

  @Override
  public void handle(@NonNull HttpServletRequest req, @NonNull HttpServletResponse res) throws Exception {
    res.setContentType(mediaType().toString());
    writeValue(this, res.getOutputStream());
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

  public HttpEntity<String> status() {
    return new ResponseEntity<>(msg, HttpStatus.valueOf(code));
  }

  public void throwIfFailed() throws RemoteException {
    if (failure()) throw new RemoteException(this);
  }

  public boolean failure() {
    return !success();
  }

  public boolean success() {
    return code == OK.value();
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
    return of(OK, null);
  }

  /** Generator. */
  @NonNull
  public static JSONReturn of(HttpStatus status, @Nullable String msg) {
    return of(status.value(), firstNonBlank(msg, status.name()));
  }

  @NonNull
  public static JSONReturn of(int code, @Nullable String msg) {
    return new JSONReturn(code, firstNonNull(msg, ""));
  }
}
