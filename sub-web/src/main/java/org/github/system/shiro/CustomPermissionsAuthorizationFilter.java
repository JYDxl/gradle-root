package org.github.system.shiro;

import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authz.PermissionsAuthorizationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

import static java.util.Arrays.stream;

public class CustomPermissionsAuthorizationFilter extends PermissionsAuthorizationFilter implements CustomFilterInvoker {
  @Override
  public boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
    String[] perms = (String[]) mappedValue;
    if (perms == null || perms.length == 0) return true;
    Subject subject = getSubject(request, response);
    return stream(perms).anyMatch(subject::isPermitted);
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
}
