package org.github.spring.restful.json;

import javax.annotation.Nonnull;

import lombok.*;

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
public class JSONBasic implements JSON {
  /** 返回的状态码. */
  private int resCode = RES_OK_CODE;
  /** 返回的信息. */
  @NonNull
  private String resMsg = RES_OK_MSG;

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

  /** WITH resCode. */
  @Nonnull
  public JSONBasic withResCode(int resCode) {
    setResCode(resCode);
    return this;
  }

  /** WITH resMsg. */
  @Nonnull
  public JSONBasic withResMsg(@Nonnull String resMsg) {
    setResMsg(resMsg);
    return this;
  }

  /** Generator. */
  @Nonnull
  public static JSONBasic of() {
    return new JSONBasic();
  }

  /** Generator. */
  @Nonnull
  public static JSONBasic of(int code, @Nonnull String msg) {
    return new JSONBasic(code, msg);
  }

  /** Generator. */
  @Nonnull
  public static JSONBasic error() {
    return of(RET_ERROR_CODE, RET_ERROR_MSG);
  }
}
