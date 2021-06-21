package org.github.shiro;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.shiro.web.filter.authc.AuthenticationFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import static javax.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED;
import static org.apache.shiro.web.util.WebUtils.toHttp;

@Slf4j
public class CustomAuthenticationFilter extends AuthenticationFilter implements CustomFilterInvoker {
  private final boolean simple;

  public CustomAuthenticationFilter(boolean simple) {
    this.simple = simple;
  }

  @Override
  protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
    if (isLoginRequest(request, response)) {
      if (isLoginSubmission(request, response)) {
        executeWEBLogin(request, response, log);
      } else {
        //进入登录页面
        if (simple) return true;
        //访问方法错误
        loginRequestNotAPost(request, response);
      }
    } else {
      notLogin(request, response);
    }
    return false;
  }

  protected boolean isLoginSubmission(ServletRequest request, @SuppressWarnings("unused") ServletResponse response) {
    return (request instanceof HttpServletRequest) && toHttp(request).getMethod().equalsIgnoreCase(POST_METHOD);
  }

  protected void loginRequestNotAPost(@SuppressWarnings("unused") ServletRequest request, ServletResponse response) {
    val httpServletResponse = toHttp(response);
    httpServletResponse.setStatus(SC_METHOD_NOT_ALLOWED);
    httpServletResponse.setHeader("Allow", "POST");
  }
}
