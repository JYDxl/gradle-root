package org.github.spring.restful.json;

import javax.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.Setter;
import static org.github.ops.spring.SpringOpsKt.*;
import static org.github.spring.footstone.IConstKt.*;

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
@Getter
@Setter
public class JSONReturn implements JSON {
  /** 返回的状态码. */
  private int    retCode = RET_OK_CODE;
  /** 返回的信息. */
  @NonNull
  private String retMsg  = RET_OK_MSG;

  @Override
  @Nonnull
  public String get() {
    return json(this, null);
  }

  @Override
  public boolean functional() {
    return false;
  }

  @Override
  public String toString() {
    return get();
  }

  /** WITH retCode. */
  @Nonnull
  public JSONReturn withRetCode(int retCode) {
    setRetCode(retCode);
    return this;
  }

  /** WITH retMsg. */
  @Nonnull
  public JSONReturn withRetMsg(@Nonnull String retMsg) {
    setRetMsg(retMsg);
    return this;
  }

  /** Generator. */
  @Nonnull
  public static JSONReturn of() {
    return new JSONReturn();
  }

  /** Generator. */
  @Nonnull
  public static JSONReturn of(int code, @Nonnull String msg) {
    return new JSONReturn(code, msg);
  }

  /** Generator. */
  @Nonnull
  public static JSONReturn error() {
    return of(RET_ERROR_CODE, RET_ERROR_MSG);
  }

  /** Generator. */
  @Nonnull
  public static JSONReturn warn() {
    return of(RET_WARN_CODE, RET_WARN_MSG);
  }
}
