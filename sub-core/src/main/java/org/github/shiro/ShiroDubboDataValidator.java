package org.github.shiro;

import lombok.val;
import org.apache.shiro.subject.Subject;
import org.apache.shiro.web.subject.WebSubject;

import static com.google.common.base.Preconditions.checkArgument;
import static org.apache.commons.lang3.StringUtils.isNotBlank;
import static org.apache.shiro.SecurityUtils.getSubject;
import static org.apache.shiro.util.ThreadContext.bind;
import static org.github.spring.ops.SpringsKt.getReq;
import static org.github.spring.ops.SpringsKt.getResp;
import static org.github.shiro.JWTUtil.getUsername;

public abstract class ShiroDubboDataValidator {
  public static <T> void validate(ShiroDubboDataWrapper<T> wrapper) {
    val current = getSubject();
    if (current.isAuthenticated() && current.getPrincipal() != null) return;
    val hasToken = isNotBlank(wrapper.getToken());
    val hasJWT   = isNotBlank(wrapper.getJwt());
    checkArgument(hasToken || hasJWT);
    val req  = getReq();
    val resp = getResp();
    if (hasToken) {
      val subject = req != null && resp != null ? new WebSubject.Builder(req, resp).sessionId(wrapper.getToken()).buildSubject() : new Subject.Builder().sessionId(wrapper.getToken()).buildSubject();
      bind(subject);
    } else {
      val username = getUsername(wrapper.getJwt());
      val jwtToken = new JWTToken(username, wrapper.getJwt());
      val subject  = req != null && resp != null ? new WebSubject.Builder(req, resp).buildSubject() : new Subject.Builder().buildSubject();
      subject.login(jwtToken);
    }
  }
}
