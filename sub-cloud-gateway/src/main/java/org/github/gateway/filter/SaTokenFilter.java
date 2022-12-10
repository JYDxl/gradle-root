package org.github.gateway.filter;

import cn.hutool.core.text.AntPathMatcher;
import com.fasterxml.jackson.databind.ObjectMapper;
import javax.annotation.Resource;
import lombok.SneakyThrows;
import org.github.gateway.handler.Result;
import org.github.gateway.props.GatewayDynamicProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufFlux;
import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.github.core.ConstKt.SA_TOKEN_PREFIX;
import static org.github.core.ConstKt.TOKEN_NAME;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Component
public class SaTokenFilter implements GlobalFilter, Ordered {
  private final AntPathMatcher              matcher = new AntPathMatcher();
  @Resource
  private       ReactiveStringRedisTemplate reactiveStringRedisTemplate;
  @Resource
  private       GatewayDynamicProperties    gatewayDynamicProperties;
  @Resource
  private       ObjectMapper                mapper;

  @Override
  public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
    ServerHttpRequest request = exchange.getRequest();
    return checkWhiteList(request)
      .flatMap(v -> checkTokenExists(v, request))
      .flatMap(v -> handle(v, exchange, chain));
  }

  private Mono<Boolean> checkWhiteList(ServerHttpRequest request) {
    String path = request.getPath().value();
    for (String item : gatewayDynamicProperties.getWhiteList()) if (matcher.match("/*" + item, path)) return Mono.just(true);
    return Mono.just(false);
  }

  private Mono<Boolean> checkTokenExists(Boolean allow, ServerHttpRequest request) {
    if (allow) return Mono.just(true);
    String token = request.getHeaders().getFirst(TOKEN_NAME);
    if (isBlank(token)) return Mono.just(false);
    return reactiveStringRedisTemplate.hasKey(SA_TOKEN_PREFIX + token);
  }

  @SneakyThrows
  private Mono<Void> handle(Boolean exists, ServerWebExchange exchange, GatewayFilterChain chain) {
    if (exists) return chain.filter(exchange);
    Result             data     = Result.of(UNAUTHORIZED, null);
    byte[]             bytes    = mapper.writeValueAsBytes(data);
    ServerHttpResponse response = exchange.getResponse();
    response.getHeaders().setContentType(APPLICATION_JSON);
    response.getHeaders().setContentLength(bytes.length);
    return response.writeAndFlushWith(Flux.just(ByteBufFlux.just(response.bufferFactory().wrap(bytes))));
  }

  @Override
  public int getOrder() {
    return HIGHEST_PRECEDENCE;
  }
}
