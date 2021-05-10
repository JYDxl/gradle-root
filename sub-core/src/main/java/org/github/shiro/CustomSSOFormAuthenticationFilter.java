package org.github.shiro;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.subject.Subject;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

@Slf4j
public class CustomSSOFormAuthenticationFilter extends CustomFormAuthenticationFilter {
    public CustomSSOFormAuthenticationFilter(boolean simple) {
        super(simple);
    }

    @Override
    protected boolean loginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        val result = super.loginSuccess(token, subject, request, response);
        sso(subject);
        return result;
    }
}
