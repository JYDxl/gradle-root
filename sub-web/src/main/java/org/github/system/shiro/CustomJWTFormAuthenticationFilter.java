package org.github.system.shiro;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.shiro.web.util.WebUtils.toHttp;
import static org.github.system.shiro.JWTUtil.username;

@Slf4j
public class CustomJWTFormAuthenticationFilter extends CustomFormAuthenticationFilter {
  @Override
  protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
    if (isNotJWT(request)) return super.createToken(request, response);
    val token    = toHttp(request).getHeader("token");
    val username = username(token);
    return new JWTToken(username, token);
  }

  protected boolean isNotJWT(ServletRequest request) {
    return !hasJWTToken(request);
  }

  protected boolean hasJWTToken(ServletRequest request) {
    return isNotBlank(toHttp(request).getHeader("token"));
  }

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    if (isNotJWT(request)) return super.onAccessDenied(request, response);
    if (log.isDebugEnabled()) log.debug("JWT Login submission detected. Attempting to execute login.");
    return executeLogin(request, response);
  }

  @Override
  protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
    if (isNotJWT(request)) return super.onLoginSuccess(token, subject, request, response);
    return true;
  }

  @Override
  protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
    //if (isNotJWT(request)) return;
    //TODO 刷新token的过期时间.
  }
}
