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
  private int    retCode = 0;
  /** 返回的信息. */
  @NonNull
  private String retMsg  = "OK";

  @Override
  public String toString() {
    return get();
  }

  @NonNull
  @Override
  public String get() {
    return json(this, null);
  }

  @Override
  public boolean functional() {
    return false;
  }

  /** WITH retCode. */
  @NonNull
  public JSONReturn withRetCode(int retCode) {
    setRetCode(retCode);
    return this;
  }

  /** WITH retMsg. */
  @NonNull
  public JSONReturn withRetMsg(@NonNull String retMsg) {
    setRetMsg(retMsg);
    return this;
  }

  /** Generator. */
  @NonNull
  public static JSONReturn error() {
    return of(-2, "SYSTEM ERROR");
  }

  /** Generator. */
  @NonNull
  public static JSONReturn of(int code, @NonNull String msg) {
    return new JSONReturn(code, msg);
  }

  /** Generator. */
  @NonNull
  public static JSONReturn warn() {
    return of(-1, "PARAMS ERROR");
  }
}
