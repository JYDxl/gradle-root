package org.github.spring.restful.json;

import lombok.*;
import static org.github.ops.SpringsKt.*;

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
  private          int    retCode = 0;
  /** 返回的信息. */
  private @NonNull String retMsg  = "OK";

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
    return of(-2, "系统错误");
  }

  /** Generator. */
  public static @NonNull JSONReturn of(int code, @NonNull String msg) {
    return new JSONReturn(code, msg);
  }

  /** Generator. */
  public static @NonNull JSONReturn warn() {
    return of(-1, "参数错误");
  }
}
