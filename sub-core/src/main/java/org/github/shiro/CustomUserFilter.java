package org.github.shiro;

import lombok.extern.slf4j.Slf4j;
import org.apache.shiro.web.filter.authc.UserFilter;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Slf4j
public class CustomUserFilter extends UserFilter implements CustomFilterInvoker {
    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isNotJWT(request)) {
            notLogin(request, response);
            return false;
        }
        return jwtLogin(request, response, log);
    }

    @Override
    protected boolean isAccessAllowed(ServletRequest request, ServletResponse response, Object mappedValue) {
        return getSubject(request, response).getPrincipal() != null;
    }

    @Override
    protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
        if (isNotJWT(request)) return;
        refreshToken(request, response);
    }
}
