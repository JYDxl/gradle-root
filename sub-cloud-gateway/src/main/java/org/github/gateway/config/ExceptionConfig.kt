package org.github.gateway.config;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.github.gateway.handler.ExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;
import static org.springframework.core.Ordered.HIGHEST_PRECEDENCE;

@Configuration
public class ExceptionConfig {
  @Bean
  @Order(HIGHEST_PRECEDENCE)
  public ExceptionHandler errorWebExceptionHandler(ObjectMapper mapper) {
    return new ExceptionHandler(mapper);
  }
}
