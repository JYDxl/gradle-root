package org.github.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.RolesAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

import static java.util.Arrays.stream;

@Slf4j
public class CustomRolesAuthorizationFilter extends RolesAuthorizationFilter implements CustomFilterInvoker {
  public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) throws IOException {
    String[] rolesArray = (String[]) mappedValue;
    if (rolesArray == null || rolesArray.length == 0) return true;
    Subject subject = getSubject(request, response);
    return stream(rolesArray).anyMatch(subject::hasRole);
  }

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws IOException {
    Subject subject = getSubject(request, response);
    if (subject.getPrincipal() == null) {
      notLogin(request, response);
    } else {
      unauthorized(request, response);
    }
    return false;
  }

  @Override public boolean onPreHandle(ServletRequest request, ServletResponse response, Object mappedValue) throws Exception {
    return isJWT(request) ? executeJWTLogin(request, response, log) : super.onPreHandle(request, response, mappedValue);
  }

  @Override
  protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
    if (isNotJWT(request)) return;
    refreshToken(request, response);
  }
}
