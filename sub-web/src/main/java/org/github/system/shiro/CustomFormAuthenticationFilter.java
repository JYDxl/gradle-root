package org.github.system.shiro;

import java.io.IOException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import lombok.*;
import lombok.extern.slf4j.*;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.springframework.beans.factory.annotation.Value;
import static com.google.common.collect.ImmutableMap.*;
import static java.util.Objects.*;
import static org.apache.shiro.web.util.WebUtils.*;

@Slf4j
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter {
  @Value("#{ @environment['shiro.sessionManager.cookie.name'] ?: T(org.apache.shiro.web.servlet.ShiroHttpSession).DEFAULT_SESSION_ID_NAME }")
  protected String sessionIdCookieName;

  @Value("#{ @environment['shiro.failureUrl'] ?: '/failure' }")
  protected String failureUrl;

  @Value("#{ @environment['shiro.unauthorizedUrl'] ?: '/unauthorized' }")
  protected String unauthorizedUrl;

  @Override
  protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
    val sessionId = requireNonNull(subject.getSession(false)).getId();
    issueRedirect(request, response, getSuccessUrl(), of(sessionIdCookieName, sessionId));
    return false;
  }

  @Override
  protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
    log.debug(e.getMessage(), e);
    try {
      issueRedirect(request, response, failureUrl);
    } catch (IOException ioe) {
      log.error(ioe.getMessage(), ioe);
    }
    return false;
  }

  @Override
  protected void saveRequestAndRedirectToLogin(ServletRequest request, ServletResponse response) throws IOException {
    issueRedirect(request, response, unauthorizedUrl);
  }
}
