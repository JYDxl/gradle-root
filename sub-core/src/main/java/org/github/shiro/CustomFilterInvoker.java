package org.github.shiro;

import lombok.val;
import org.apache.shiro.authc.AuthenticationException;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.session.mgt.DefaultWebSessionManager;
import org.github.spring.restful.json.JSON;
import org.slf4j.Logger;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import java.io.IOException;
import java.util.Objects;

import static cn.hutool.core.lang.Validator.hasChinese;
import static com.google.common.base.MoreObjects.firstNonNull;
import static com.google.common.collect.ImmutableList.toImmutableList;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.shiro.SecurityUtils.getSecurityManager;
import static org.apache.shiro.SecurityUtils.getSubject;
import static org.apache.shiro.web.util.WebUtils.toHttp;
import static org.github.shiro.JWTUtil.sign;
import static org.github.spring.restful.json.JSONReturn.warn;

public interface CustomFilterInvoker {
    default void loginFailed(ServletRequest request, ServletResponse response, String msg) throws IOException {
        resp(request, response, warn().withRetMsg(hasChinese(msg) ? msg : "登陆失败"));
    }

    default void resp(ServletRequest request, ServletResponse response, JSON json) throws IOException {
        val httpServletResponse = toHttp(response);
        httpServletResponse.setContentType(json.mediaType().toString());
        httpServletResponse.getWriter().write(firstNonNull(json.get(), "null"));
    }

    default void logoutSucceed(ServletRequest request, ServletResponse response) throws IOException {
        resp(request, response, warn().withRetMsg("退出成功"));
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

    default boolean hasJWTToken(ServletRequest request) {
        return isNotBlank(toHttp(request).getHeader("token"));
    }

    default void refreshToken(ServletRequest request, ServletResponse response) {
        val subject = getSubject();
        val principal = (User) subject.getPrincipal();
        val username = principal.getUsername();
        val password = principal.getPassword();
        val token = sign(username, password);
        toHttp(response).addHeader("token", token);
    }

    default JWTToken generateJwtToken(ServletRequest request) {
        val token = toHttp(request).getHeader("token");
        val username = JWTUtil.getUsername(token);
        return new JWTToken(username, token);
    }

    default void sso(Subject subject) {
        val current = subject.getSession(false);
        if (current != null) {
            current.setAttribute("user", subject.getPrincipal());
            val securityManager = (DefaultWebSessionManager) getSecurityManager();
            val sessionDAO = securityManager.getSessionDAO();
            val activeSessions = sessionDAO.getActiveSessions();
            val removeList = activeSessions.stream().filter(session -> currentUser(current, session)).collect(toImmutableList());
            removeList.forEach(sessionDAO::delete);
        }
    }

    default boolean currentUser(Session current, Session session) {
        val currentUser = (User) current.getAttribute("user");
        val user = (User) session.getAttribute("user");
        return !Objects.equals(current.getId(), session.getId()) && Objects.equals(currentUser.getUsername(), user.getUsername());
    }

    default boolean jwtLogin(ServletRequest request, ServletResponse response, Logger log) throws IOException {
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
}
