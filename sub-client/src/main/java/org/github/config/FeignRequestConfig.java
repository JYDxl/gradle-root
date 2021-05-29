package org.github.config;

import feign.RequestInterceptor;
import feign.RequestTemplate;
import lombok.val;

import static java.util.Objects.requireNonNull;
import static org.github.spring.ops.SpringsKt.getReq;

public class FeignRequestConfig implements RequestInterceptor {
  @Override
  public void apply(RequestTemplate template) {
    val req = requireNonNull(getReq());

    val headerNames = req.getHeaderNames();
    while (headerNames.hasMoreElements()) {
      String name = headerNames.nextElement();
      template.header(name, req.getHeader(name));
    }

    template.query("token", req.getParameter("token"));
  }
}
