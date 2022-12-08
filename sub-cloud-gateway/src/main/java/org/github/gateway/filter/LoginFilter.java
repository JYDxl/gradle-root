package org.github.gateway.filter;

import cn.hutool.core.text.AntPathMatcher;
import org.github.gateway.props.WhiteListProperties;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.data.redis.core.ReactiveStringRedisTemplate;
import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Mono;

import javax.annotation.Resource;
import java.util.Objects;

import static org.apache.commons.lang3.StringUtils.isBlank;
import static org.github.core.ConstKt.TOKEN_NAME;
import static org.springframework.http.HttpStatus.UNAUTHORIZED;
import static reactor.core.publisher.Mono.just;

@Component
public class LoginFilter implements GlobalFilter, Ordered {
    private final AntPathMatcher matcher = new AntPathMatcher();
    @Resource
    private ReactiveStringRedisTemplate reactiveStringRedisTemplate;
    @Resource
    private WhiteListProperties whiteListProperties;

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        ServerHttpRequest request = exchange.getRequest();
        return checkWhiteList(request)
                .flatMap(v -> checkTokenExists(v, request))
                .flatMap(v -> handle(v, exchange, chain));
    }

    @Override
    public int getOrder() {
        return HIGHEST_PRECEDENCE;
    }

    private Mono<Boolean> checkWhiteList(ServerHttpRequest request) {
        String path = request.getPath().contextPath().value();
        for (String item : whiteListProperties.getWhiteList()) if (matcher.match("/*" + item, path)) return just(true);
        return just(false);
    }

    private Mono<Void> handle(Boolean exists, ServerWebExchange exchange, GatewayFilterChain chain) {
        if (exists) return chain.filter(exchange);
        ServerHttpResponse response = exchange.getResponse();
        response.setStatusCode(UNAUTHORIZED);
        return exchange.getResponse().setComplete();
    }

    private Mono<Boolean> checkTokenExists(Boolean allow, ServerHttpRequest request) {
        if (allow) return just(true);
        String token = request.getHeaders().getFirst(TOKEN_NAME);
        if (isBlank(token)) return just(false);
        //TODO 和token缓存匹配
        return reactiveStringRedisTemplate.opsForValue().get(token).map(Objects::nonNull);
    }
}
