package org.github.shiro;

import lombok.val;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

public class CustomSSOJWTFormAuthenticationFilter extends CustomJWTFormAuthenticationFilter {
    public CustomSSOJWTFormAuthenticationFilter(boolean simple) {
        super(simple);
    }

    @Override
    protected boolean loginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        val result = super.loginSuccess(token, subject, request, response);
        sso(subject);
        return result;
    }
}
