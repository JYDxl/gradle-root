package org.github.system.shiro;

import lombok.val;
import org.github.spring.restful.json.JSON;

import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

import static com.google.common.base.MoreObjects.firstNonNull;
import static org.apache.shiro.web.util.WebUtils.toHttp;

public interface CustomFilterInvoker {
    default void resp(ServletRequest request, ServletResponse response, JSON json) throws Exception {
        val httpServletResponse = toHttp(response);
        httpServletResponse.setContentType(json.mediaType().toString());
        httpServletResponse.getWriter().write(firstNonNull(json.get(), "null"));
    }
}
