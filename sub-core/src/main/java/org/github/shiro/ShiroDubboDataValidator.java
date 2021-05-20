package org.github.shiro;

import lombok.val;
import org.apache.shiro.subject.Subject;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.shiro.SecurityUtils.getSubject;
import static org.apache.shiro.util.ThreadContext.bind;
import static org.github.shiro.JWTUtil.getUsername;

public abstract class ShiroDubboDataValidator {
    public static <T> Subject validate(ShiroDubboDataWrapper<T> wrapper) {
        val hasToken = isNotBlank(wrapper.getToken());
        val hasJWT = isNotBlank(wrapper.getJwt());
        checkArgument(hasToken || hasJWT);
        if (hasToken) {
            val subject = new Subject.Builder().sessionId(wrapper.getToken()).buildSubject();
            bind(subject);
            return subject;
        } else {
            val username = getUsername(wrapper.getJwt());
            val jwtToken = new JWTToken(username, wrapper.getJwt());
            val subject = getSubject();
            subject.login(jwtToken);
            return subject;
        }
    }
}
