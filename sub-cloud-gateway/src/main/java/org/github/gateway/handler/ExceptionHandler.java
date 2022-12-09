package org.github.gateway.handler;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.Data;
import lombok.SneakyThrows;
import org.jetbrains.annotations.NotNull;
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler;
import org.springframework.http.server.reactive.ServerHttpResponse;
import org.springframework.web.server.ResponseStatusException;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;
import reactor.netty.ByteBufFlux;

import static org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR;
import static org.springframework.http.MediaType.APPLICATION_JSON;

@Data
public class ExceptionHandler implements ErrorWebExceptionHandler {
    private final ObjectMapper mapper;

    @SneakyThrows
    @NotNull
    @Override
    public Mono<Void> handle(@NotNull ServerWebExchange exchange, @NotNull Throwable ex) {
        Result data = Result.of(INTERNAL_SERVER_ERROR, null);
        if (ex instanceof ResponseStatusException e) data = Result.of(e.getStatus(), null);
        byte[] bytes = mapper.writeValueAsBytes(data);
        ServerHttpResponse response = exchange.getResponse();
        response.getHeaders().setContentType(APPLICATION_JSON);
        response.getHeaders().setContentLength(bytes.length);
        return response.writeAndFlushWith(Flux.just(ByteBufFlux.just(response.bufferFactory().wrap(bytes))));
    }
}
