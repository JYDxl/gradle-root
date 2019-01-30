package org.github.spring.restful.json;

import javax.annotation.Nonnull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import org.github.ops.ObjectOpsKt;
import org.github.spring.footstone.IConstKt;
import org.jetbrains.annotations.Contract;

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
public class JSONBasic implements JSON {
  /** 返回的状态码. */
  private int retCode = IConstKt.RET_OK_CODE;

  /** 返回的信息. */
  @NonNull
  private String retMsg = IConstKt.RET_OK_MSG;

  @Override
  @Nonnull
  public String get() {
    return ObjectOpsKt.json(this);
  }

  @Override
  public boolean functional() {
    return false;
  }

  @Override
  public void release() {
    withRetCode(IConstKt.RET_OK_CODE).withRetMsg(IConstKt.RET_OK_MSG);
  }

  @Override
  public String toString() {
    return get();
  }

  /** WITH retCode. */
  @Nonnull
  public JSONBasic withRetCode(int retCode) {
    setRetCode(retCode);
    return this;
  }

  /** WITH retMsg. */
  @Nonnull
  public JSONBasic withRetMsg(@Nonnull String retMsg) {
    setRetMsg(retMsg);
    return this;
  }

  /** Generator. */
  @Contract(" -> new")
  @Nonnull
  public static JSONBasic of() {
    return new JSONBasic();
  }

  /** Generator. */
  @Contract("_, _ -> new")
  @Nonnull
  public static JSONBasic of(int code, @Nonnull String msg) {
    return new JSONBasic(code, msg);
  }

  /** Generator. */
  @Nonnull
  public static JSONBasic error() {
    return of(IConstKt.RET_ERROR_CODE, IConstKt.RET_ERROR_MSG);
  }
}
