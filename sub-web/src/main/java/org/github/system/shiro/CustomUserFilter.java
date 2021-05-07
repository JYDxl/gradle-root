package org.github.system.shiro;

import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomUserFilter extends UserFilter implements CustomFilterInvoker {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        notLogin(request, response);
        return false;
    }
}
