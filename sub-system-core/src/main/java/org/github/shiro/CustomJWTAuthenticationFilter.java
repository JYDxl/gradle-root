package org.github.shiro;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Slf4j
public class CustomJWTAuthenticationFilter extends CustomAuthenticationFilter {
  public CustomJWTAuthenticationFilter(boolean simple) {
    super(simple);
  }

  @Override
  public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
    return isJWT(request) ? executeJWTLogin(request, response, log) : super.onPreHandle(request, response, mappedValue);
  }

//  @Override
//  protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
//    if (isNotJWT(request)) return;
//    refreshToken(request, response);
//  }
}
