package org.github.system.shiro;

import lombok.val;
import org.github.spring.restful.json.JSON;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;

import static com.google.common.base.MoreObjects.firstNonNull;
import static org.apache.shiro.web.util.WebUtils.toHttp;
import static org.github.spring.restful.json.JSONReturn.warn;

public interface CustomFilterInvoker {
  default void loginFailed(ServletRequest request, ServletResponse response) throws IOException {
    resp(request, response, warn().withRetMsg("登陆失败"));
  }

  static void resp(ServletRequest request, ServletResponse response, JSON json) throws IOException {
    val httpServletResponse = toHttp(response);
    httpServletResponse.setContentType(json.mediaType().toString());
    httpServletResponse.getWriter().write(firstNonNull(json.get(), "null"));
  }

  default void logoutSucceed(ServletRequest request, ServletResponse response) throws IOException {
    resp(request, response, warn().withRetMsg("退出成功"));
  }

  default void notLogin(ServletRequest request, ServletResponse response) throws IOException {
    resp(request, response, warn().withRetMsg("用户未登录"));
  }

  default void unauthorized(ServletRequest request, ServletResponse response) throws IOException {
    resp(request, response, warn().withRetMsg("权限不足"));
  }
}
