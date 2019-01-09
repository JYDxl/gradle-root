package org.github.spring.restful.json;

import javax.annotation.Nonnull;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.github.spring.footstone.AbstractEntity;
import com.fasterxml.jackson.annotation.JsonIgnore;
import static javax.servlet.http.HttpServletResponse.SC_OK;
import static org.github.spring.footstone.IConstKt.RET_ERROR_CODE;
import static org.github.spring.footstone.IConstKt.RET_ERROR_MSG;
import static org.github.spring.footstone.IConstKt.RET_OK_CODE;
import static org.github.spring.footstone.IConstKt.RET_OK_MSG;
import static org.github.spring.footstone.IConstKt.getAPI_VERSION;

/**
 * JSON of basic.
 *
 * <pre>
 *   return JSONBasic.of();
 * </pre>
 *
 * @author JYD_XL
 * @see org.github.spring.restful.Returnable
 * @see org.github.spring.restful.json.JSON
 * @see AbstractEntity
 */
public class JSONBasic extends AbstractEntity implements JSON {
  /** 返回的状态码. */
  private int retCode = RET_OK_CODE;

  /** 返回的信息. */
  @Nonnull
  private String retMsg = RET_OK_MSG;

  /** HTTP状态码. */
  @JsonIgnore
  private int status = SC_OK;

  /** Constructor. */
  @SuppressWarnings("WeakerAccess")
  public JSONBasic() {}

  /** Constructor. */
  @SuppressWarnings("WeakerAccess")
  public JSONBasic(int retCode, @Nonnull String retMsg) {
    withRetCode(retCode).withRetMsg(retMsg);
  }

  /** Constructor. */
  @SuppressWarnings("WeakerAccess")
  public JSONBasic(int status, int retCode, @Nonnull String retMsg) {
    withStatus(status).withRetCode(retCode).withRetMsg(retMsg);
  }

  @Deprecated
  @Override
  @SuppressWarnings("deprecation")
  public void collect(@Nonnull HttpServletRequest request, @Nonnull HttpServletResponse response) throws Exception {
    if (SC_OK == status) {
      JSON.super.collect(request, response);
    } else {
      response.sendError(status, retMsg);
    }
  }

  @Deprecated
  @Override
  @SuppressWarnings("deprecation")
  public boolean functional() {
    return false;
  }

  @Override
  @SuppressWarnings("deprecation")
  public void release() {
    withStatus(SC_OK).withRetCode(RET_OK_CODE).withRetMsg(RET_OK_MSG);
  }

  @Override
  @Nonnull
  public String get() {
    return toString();
  }

  /** GET API version. */
  @Nonnull
  public String getApiVersion() {
    return getAPI_VERSION();
  }

  /** GET retCode. */
  public int getRetCode() {
    return retCode;
  }

  /** SET retCode. */
  @SuppressWarnings("WeakerAccess")
  public void setRetCode(int retCode) {
    this.retCode = retCode;
  }

  /** GET retMsg. */
  @Nonnull
  public String getRetMsg() {
    return retMsg;
  }

  /** SET retMsg. */
  @SuppressWarnings("WeakerAccess")
  public void setRetMsg(@Nonnull String retMsg) {
    this.retMsg = retMsg;
  }

  /** GET status. */
  public int getStatus() {
    return status;
  }

  /** SET status. */
  @SuppressWarnings("WeakerAccess")
  public void setStatus(int status) {
    this.status = status;
  }

  /** WITH retCode. */
  @Nonnull
  @SuppressWarnings("WeakerAccess")
  public JSONBasic withRetCode(int retCode) {
    setRetCode(retCode);
    return this;
  }

  /** WITH retMsg. */
  @Nonnull
  @SuppressWarnings({"WeakerAccess", "UnusedReturnValue"})
  public JSONBasic withRetMsg(@Nonnull String retMsg) {
    setRetMsg(retMsg);
    return this;
  }

  /** WITH status. */
  @Nonnull
  @SuppressWarnings("WeakerAccess")
  public JSONBasic withStatus(int status) {
    setStatus(status);
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
  public static JSONBasic of(int status, int code, @Nonnull String msg) {
    return new JSONBasic(status, code, msg);
  }

  /** Generator. */
  @Nonnull
  public static JSONBasic error() {
    return of(SC_OK, RET_ERROR_CODE, RET_ERROR_MSG);
  }
}
