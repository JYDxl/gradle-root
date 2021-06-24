package org.github.config;

import lombok.*;
import feign.RequestInterceptor;
import feign.RequestTemplate;
import static java.util.Objects.*;
import static org.github.shiro.ops.ShiroKt.JSESSIONID;
import static org.github.spring.ops.SpringKt.*;

public class FeignRequestConfig implements RequestInterceptor {
  @Override
  public void apply(RequestTemplate template) {
    val req = requireNonNull(getReq());

    val headerNames = req.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String name = headerNames.nextElement();
      template.header(name, req.getHeader(name));
    }

    template.query(JSESSIONID, req.getParameter(JSESSIONID));
  }
}