package org.github.shiro;

import lombok.val;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.authc.AuthenticationToken;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.github.spring.restful.json.JSON;
import org.github.spring.restful.json.JSONDataReturn;
import org.github.spring.restful.json.JSONMapper;
import org.slf4j.Logger;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Objects;

import static cn.hutool.core.lang.Validator.hasChinese;
import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.collect.ImmutableList.toImmutableList;
import static java.util.Optional.ofNullable;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.shiro.SecurityUtils.getSecurityManager;
import static org.apache.shiro.SecurityUtils.getSubject;
import static org.apache.shiro.web.util.WebUtils.toHttp;
import static org.github.shiro.JWTUtil.getUsername;
import static org.github.shiro.JWTUtil.sign;
import static org.github.spring.bootstrap.AppCtxHolder.getAppCtx;
import static org.github.spring.restful.json.JSONReturn.warn;
import static org.springframework.beans.BeanUtils.copyProperties;

public interface CustomFilterInvoker {
    default void resp(ServletRequest request, ServletResponse response, JSON json) throws IOException {
        val httpServletResponse = toHttp(response);
        httpServletResponse.setContentType(json.mediaType().toString());
        httpServletResponse.getWriter().write(firstNonNull(json.get(), "null"));
    }

    default void logoutSucceed(ServletRequest request, ServletResponse response) throws IOException {
        resp(request, response, warn().withRetMsg("退出成功"));
    }

    default void loginFailed(ServletRequest request, ServletResponse response, String msg) throws IOException {
        resp(request, response, warn().withRetMsg(hasChinese(msg) ? msg : "登陆失败"));
    }

    default void notLogin(ServletRequest request, ServletResponse response) throws IOException {
        resp(request, response, warn().withRetMsg("用户未登录"));
    }

    default void unauthorized(ServletRequest request, ServletResponse response) throws IOException {
        resp(request, response, warn().withRetMsg("权限不足"));
    }

    default boolean isNotJWT(ServletRequest request) {
        return !hasJWTToken(request);
    }

    default boolean isJWT(ServletRequest request) {
        return hasJWTToken(request);
    }

    default boolean hasJWTToken(ServletRequest request) {
        return isNotBlank(toHttp(request).getHeader("token"));
    }

    default JWTToken generateJwtToken(ServletRequest request) {
        val token = toHttp(request).getHeader("token");
        val username = getUsername(token);
        return new JWTToken(username, token);
    }

    default boolean executeJWTLogin(ServletRequest request, ServletResponse response, Logger log) throws IOException {
        val token = generateJwtToken(request);
        Subject subject = getSubject();
        try {
            subject.login(token);
            return true;
        } catch (AuthenticationException e) {
            log.warn(e.getMessage(), e);
            loginFailed(request, response, e.getMessage());
            return false;
        }
    }

    default void refreshToken(ServletRequest request, ServletResponse response) {
        val subject = getSubject();
        val principal = (User) subject.getPrincipal();
        val username = principal.getUsername();
        val password = principal.getPassword();
        val token = sign(username, password);
        toHttp(response).addHeader("token", token);
    }

    default AuthenticationToken generateWEBToken(ServletRequest request, @SuppressWarnings("unused") ServletResponse response) throws Exception {
        val appCtx = getAppCtx();
        val mapper = appCtx.getBean(JSONMapper.class);
        val token = mapper.readValue(request.getInputStream(), WEBLogin.class);
        token.setHost(request.getRemoteHost());
        return new UsernamePasswordToken(token.getUsername(), token.getPassword(), token.isRememberMe(), token.getHost());
    }

    default void executeWEBLogin(ServletRequest request, ServletResponse response, Logger log) throws Exception {
        AuthenticationToken token = generateWEBToken(request, response);
        try {
            val subject = getSubject();
            subject.login(token);
            onWEBLoginSuccess(token, subject, request, response);
        } catch (AuthenticationException e) {
            onWEBLoginFailure(token, e, request, response, log);
        }
    }

    default void onWEBLoginSuccess(@SuppressWarnings("unused") AuthenticationToken token, Subject subject, ServletRequest request, ServletResponse response) throws Exception {
        val principal = subject.getPrincipal();
        val user = principal.getClass().getConstructor().newInstance();
        copyProperties(principal, user);
        val session = subject.getSession(false);
        ((User) user).setToken(ofNullable(session).map(Session::getId).map(Objects::toString).orElse(null));
        resp(request, response, new JSONDataReturn<>(user));
    }

    default void onWEBLoginFailure(@SuppressWarnings("unused") AuthenticationToken token, AuthenticationException e, ServletRequest request, ServletResponse response, Logger log) throws Exception {
        log.warn(e.getMessage(), e);
        loginFailed(request, response, e.getMessage());
    }

    default void sessionKickOut(Subject subject) {
        val current = subject.getSession(false);
        if (current != null) {
            current.setAttribute("user", subject.getPrincipal());
            val securityManager = (DefaultWebSessionManager) getSecurityManager();
            val sessionDAO = securityManager.getSessionDAO();
            val activeSessions = sessionDAO.getActiveSessions();
            val removeList = activeSessions.stream().filter(session -> sameUser(current, session)).collect(toImmutableList());
            removeList.forEach(sessionDAO::delete);
        }
    }

    default boolean sameUser(Session current, Session session) {
        val currentUser = (User) current.getAttribute("user");
        val user = (User) session.getAttribute("user");
        return !Objects.equals(current.getId(), session.getId()) && Objects.equals(currentUser.getUsername(), user.getUsername());
    }
}
