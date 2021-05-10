package org.github.shiro;

import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomCommonAuthenticationFilter extends CustomJWTAuthenticationFilter {
    public CustomCommonAuthenticationFilter(boolean simple) {
        super(simple);
    }

    @Override
    public void onWEBLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        super.onWEBLoginSuccess(token, subject, request, response);
        sessionKickOut(subject);
    }
}
