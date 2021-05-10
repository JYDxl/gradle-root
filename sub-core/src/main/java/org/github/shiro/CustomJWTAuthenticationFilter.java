package org.github.shiro;

import lombok.extern.slf4j.Slf4j;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Slf4j
public class CustomJWTAuthenticationFilter extends CustomAuthenticationFilter {
    public CustomJWTAuthenticationFilter(boolean simple) {
        super(simple);
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isNotJWT(request)) return super.onAccessDenied(request, response);
        if (log.isDebugEnabled()) log.debug("JWT Login submission detected. Attempting to execute login.");
        return executeJWTLogin(request, response, log);
    }

    @Override
    protected void postHandle(ServletRequest request, ServletResponse response) throws Exception {
        if (isNotJWT(request)) return;
        refreshToken(request, response);
    }
}
