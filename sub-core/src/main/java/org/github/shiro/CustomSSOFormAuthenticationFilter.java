package org.github.shiro;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Objects;

import static com.google.common.collect.ImmutableList.toImmutableList;
import static org.apache.shiro.SecurityUtils.getSecurityManager;

@Slf4j
public class CustomSSOFormAuthenticationFilter extends CustomFormAuthenticationFilter {
  public CustomSSOFormAuthenticationFilter(boolean simple) {
    super(simple);
  }

  @Override
  protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
    super.onLoginSuccess(token, subject, request, response);
    val current = subject.getSession(false);
    if (current != null) {
      current.setAttribute("user", subject.getPrincipal());
      val securityManager = (DefaultWebSessionManager) getSecurityManager();
      val sessionDAO      = securityManager.getSessionDAO();
      val activeSessions  = sessionDAO.getActiveSessions();
      val removeList      = activeSessions.stream().filter(session -> currentUser(current, session)).collect(toImmutableList());
      removeList.forEach(sessionDAO::delete);
    }
    return false;
  }

  private boolean currentUser(Session current, Session session) {
    val currentUser = (User) current.getAttribute("user");
    val user        = (User) session.getAttribute("user");
    return !Objects.equals(current.getId(), session.getId()) && Objects.equals(currentUser.getUsername(), user.getUsername());
  }
}
