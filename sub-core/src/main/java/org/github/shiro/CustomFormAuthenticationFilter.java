package org.github.shiro;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.SneakyThrows;
import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.filter.authc.FormAuthenticationFilter;
import org.github.spring.restful.json.JSONDataReturn;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Objects;

import static java.util.Optional.ofNullable;
import static org.github.spring.bootstrap.AppCtxHolder.getAppCtx;
import static org.springframework.beans.BeanUtils.copyProperties;

import static javax.servlet.http.HttpServletResponse.SC_METHOD_NOT_ALLOWED;
import static org.apache.shiro.web.util.WebUtils.toHttp;

@Slf4j
public class CustomFormAuthenticationFilter extends FormAuthenticationFilter implements CustomFilterInvoker {
    private final boolean simple;

    public CustomFormAuthenticationFilter(boolean simple) {
        this.simple = simple;
    }

    @Override
    protected boolean onAccessDenied(ServletRequest request, ServletResponse response) throws Exception {
        if (isLoginRequest(request, response)) {
            if (isLoginSubmission(request, response)) {
                if (log.isDebugEnabled()) log.debug("WEB Login submission detected. Attempting to execute login.");
                executeLogin(request, response);
            } else {
                if (simple) return true;
                //访问方法错误
                onLoginRequestNotAPost(request, response);
            }
        } else {
            notLogin(request, response);
        }
        return false;
    }

    @Override
    protected boolean onLoginSuccess(AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        val principal = subject.getPrincipal();
        val user = principal.getClass().getConstructor().newInstance();
        copyProperties(principal, user);
        val session = subject.getSession(false);
        ((User) user).setToken(ofNullable(session).map(Session::getId).map(Objects::toString).orElse(null));
        resp(request, response, new JSONDataReturn<>(user));
        return false;
    }

    @Override
    protected boolean onLoginFailure(AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response) {
        log.warn(e.getMessage(), e);
        try {
            loginFailed(request, response, e.getMessage());
        } catch (Exception ex) {
            log.error(ex.getMessage(), ex);
        }
        return false;
    }

    protected void onLoginRequestNotAPost(@SuppressWarnings("unused") ServletRequest request, ServletResponse response) {
        val httpServletResponse = toHttp(response);
        httpServletResponse.setStatus(SC_METHOD_NOT_ALLOWED);
        httpServletResponse.setHeader("Allow", "POST");
    }

    @SneakyThrows(IOException.class)
    @Override
    protected AuthenticationToken createToken(ServletRequest request, ServletResponse response) {
        val appCtx = getAppCtx();
        val mapper = appCtx.getBean(ObjectMapper.class);
        val token = mapper.readValue(request.getInputStream(), WEBLogin.class);
        token.setHost(getHost(request));
        return new UsernamePasswordToken(token.getUsername(), token.getPassword(), token.isRememberMe(), token.getHost());
    }
}
