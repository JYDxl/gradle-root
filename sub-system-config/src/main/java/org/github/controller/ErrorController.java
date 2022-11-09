package org.github.controller;

import java.util.List;
import java.util.Map;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import lombok.*;
import org.springframework.boot.autoconfigure.web.ServerProperties;
import org.springframework.boot.autoconfigure.web.servlet.error.BasicErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import static cn.hutool.core.bean.BeanUtil.*;
import static org.github.spring.restful.json.JSONReturn.*;
import static org.springframework.http.HttpStatus.*;
import static org.springframework.http.ResponseEntity.ok;

@Controller
@RequestMapping("${server.error.path:${error.path:/error}}")
public class ErrorController extends BasicErrorController {
  public ErrorController(ErrorAttributes errorAttributes, ServerProperties serverProperties, List<ErrorViewResolver> errorViewResolvers) {
    super(errorAttributes, serverProperties.getError(), errorViewResolvers);
  }

  @Deprecated
  @Override
  public ModelAndView errorHtml(HttpServletRequest request, HttpServletResponse response) {
    return super.errorHtml(request, response);
  }

  @RequestMapping
  @Override
  public ResponseEntity<Map<String,Object>> error(HttpServletRequest request) {
    val error = super.error(request);
    if (error.getStatusCode().equals(NOT_FOUND)) return ok().body(beanToMap(path(null)));
    return ok().body(beanToMap(external(null)));
  }
}
