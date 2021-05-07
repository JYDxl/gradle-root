package org.github.system.shiro;

import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import static org.github.spring.restful.json.JSONReturn.warn;

public class CustomUserFilter extends UserFilter implements CustomFilterInvoker {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        resp(request, response, warn().withRetMsg("用户未登录"));
        return false;
    }
}
