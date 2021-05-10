package org.github.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Slf4j
public class CustomJWTFormAuthenticationFilter extends CustomFormAuthenticationFilter {
  public CustomJWTFormAuthenticationFilter(boolean simple) {
    super(simple);
  }

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    if (isNotJWT(request)) return super.onAccessDenied(request, response);
    if (log.isDebugEnabled()) log.debug("JWT Login submission detected. Attempting to execute login.");
    return executeLogin(request, response);
  }

  @Override
  protected AuthenticationToken generateToken(ServletRequest request, ServletResponse response) throws Exception {
    if (isNotJWT(request)) return super.generateToken(request, response);
    return generateJwtToken(request);
  }

  @Override
  protected boolean loginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
    if (isNotJWT(request)) return super.loginSuccess(token, subject, request, response);
    return true;
  }

  @Override
  protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
    if (isNotJWT(request)) return;
    refreshToken(request, response);
  }
}
