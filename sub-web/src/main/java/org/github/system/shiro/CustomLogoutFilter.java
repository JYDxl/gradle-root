package org.github.system.shiro;

import org.apache.shiro.web.filter.authc.LogoutFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import static org.github.spring.restful.json.JSONReturn.of;

public class CustomLogoutFilter extends LogoutFilter implements CustomFilterInvoker {
    @Override
    protected void issueRedirect(ServletRequest request, ServletResponse response, String redirectUrl) throws Exception {
        resp(request, response, of().withRetMsg("登出成功"));
    }
}
