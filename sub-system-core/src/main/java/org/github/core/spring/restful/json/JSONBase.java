package org.github.core.spring.restful.json;

import io.swagger.annotations.ApiModelProperty;
import org.jetbrains.annotations.Nullable;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.Data;
import org.jetbrains.annotations.NotNull;
import org.github.core.exception.RemoteException;
import org.springframework.http.HttpStatus;
import static cn.hutool.core.text.CharSequenceUtil.firstNonBlank;
import static com.google.common.base.MoreObjects.firstNonNull;
import static org.github.core.spring.ops.SpringKt.json;
import static org.github.core.spring.ops.SpringKt.writeValue;
import static org.springframework.http.HttpStatus.OK;

/**
 * JSON of basic.
 *
 * @author JYD_XL
 * @see java.io.Serializable
 * @see java.util.function.Supplier
 */
@Data
public class JSONBase implements JSON {
  @ApiModelProperty("状态")
  private int    code;
  @ApiModelProperty("信息")
  @NotNull
  private String msg;

  public JSONBase() {
    this(OK.value(), OK.name());
  }

  private JSONBase(int code, @NotNull String msg) {
    this.code = code;
    this.msg  = msg;
  }

  @Override
  public void handle(@NotNull HttpServletRequest req, @NotNull HttpServletResponse res) throws Exception {
    res.setContentType(mediaType().toString());
    writeValue(this, res.getOutputStream());
  }

  @Override
  @NotNull
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
    return code == OK.value();
  }

  /** WITH msg. */
  @NotNull
  public JSONBase withMsg(@NotNull String msg) {
    setMsg(msg);
    return this;
  }

  /** Generator. */
  @NotNull
  public static JSONBase ok() {
    return of(OK, null);
  }

  /** Generator. */
  @NotNull
  public static JSONBase of(HttpStatus status, @Nullable String msg) {
    return of(status.value(), firstNonBlank(msg, status.name()));
  }

  @NotNull
  public static JSONBase of(int code, @Nullable String msg) {
    return new JSONBase(code, firstNonNull(msg, ""));
  }
}
