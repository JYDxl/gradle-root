package org.github.gateway.filter;

import javax.annotation.Resource;
import org.github.gateway.props.WhiteListProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import cn.hutool.core.text.AntPathMatcher;
import reactor.core.publisher.Mono;
import static org.apache.commons.lang3.StringUtils.*;
import static org.github.core.ConstKt.*;
import static org.springframework.http.HttpStatus.*;
import static reactor.core.publisher.Mono.*;

@Component
public class SaTokenFilter implements GlobalFilter, Ordered {
  private final AntPathMatcher              matcher = new AntPathMatcher();
  @Resource
  private       ReactiveStringRedisTemplate reactiveStringRedisTemplate;
  @Resource
  private       WhiteListProperties         whiteListProperties;

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    ServerHttpRequest request = exchange.getRequest();
    return checkWhiteList(request)
      .flatMap(v -> checkTokenExists(v, request))
      .flatMap(v -> handle(v, exchange, chain));
  }

  private Mono<Boolean> checkWhiteList(ServerHttpRequest request) {
    String path = request.getPath().value();
    for (String item : whiteListProperties.getWhiteList()) if (matcher.match("/*" + item, path)) return just(true);
    return just(false);
  }

  private Mono<Boolean> checkTokenExists(Boolean allow, ServerHttpRequest request) {
    if (allow) return just(true);
    String token = request.getHeaders().getFirst(TOKEN_NAME);
    if (isBlank(token)) return just(false);
    return reactiveStringRedisTemplate.hasKey(SA_TOKEN_PREFIX + token);
  }

  private Mono<Void> handle(Boolean exists, ServerWebExchange exchange, GatewayFilterChain chain) {
    if (exists) return chain.filter(exchange);
    ServerHttpResponse response = exchange.getResponse();
    response.setStatusCode(UNAUTHORIZED);
    return exchange.getResponse().setComplete();
  }

  @Override
  public int getOrder() {
    return HIGHEST_PRECEDENCE;
  }

  private static final String SA_TOKEN_PREFIX = "token:login:token:";
}
