package org.github.system.shiro;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.github.spring.restful.json.JSONDataReturn;
import org.github.web.model.dto.UserInfoDTO;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.util.Objects;

import static java.util.Optional.ofNullable;
// import static javax.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED;
// import static org.apache.shiro.web.util.WebUtils.toHttp;
import static org.github.system.shiro.CustomFilterInvoker.resp;
import static org.springframework.beans.BeanUtils.copyProperties;

@Slf4j
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter implements CustomFilterInvoker {
  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    if (isLoginRequest(request, response)) {
      if (isLoginSubmission(request, response)) {
        if (log.isDebugEnabled()) log.debug("WEB Login submission detected. Attempting to execute login.");
        executeLogin(request, response);
      } else {
        //访问方法错误
        // onLoginRequestNotAPost(request, response);
        return true;
      }
    } else {
      notLogin(request, response);
    }
    return false;
  }

  @Override
  protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
    val userInfo = new UserInfoDTO();
    copyProperties(subject.getPrincipal(), userInfo);
    val session = subject.getSession(false);
    userInfo.setSessionId(ofNullable(session).map(Session::getId).map(Objects::toString).orElse(null));
    resp(request, response, new JSONDataReturn<>(userInfo));
    return false;
  }

  @Override
  protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
    log.warn(e.getMessage(), e);
    try {
      //TODO 根据异常分类
      loginFailed(request, response);
    } catch (Exception ex) {
      log.error(ex.getMessage(), ex);
    }
    return false;
  }

  // protected void onLoginRequestNotAPost(@SuppressWarnings("unused") ServletRequest request, ServletResponse response) {
  //   val httpServletResponse = toHttp(response);
  //   httpServletResponse.setStatus(SC_METHOD_NOT_ALLOWED);
  //   httpServletResponse.setHeader("Allow", "POST");
  // }
}
