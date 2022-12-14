package org.github.gateway.handler

import com.fasterxml.jackson.databind.ObjectMapper
import lombok.SneakyThrows
import org.github.gateway.dto.Result
import org.springframework.boot.web.reactive.error.ErrorWebExceptionHandler
import org.springframework.http.HttpStatus.INTERNAL_SERVER_ERROR
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.web.server.ResponseStatusException
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Flux.just
import reactor.core.publisher.Mono

class ExceptionHandler(private val mapper: ObjectMapper) : ErrorWebExceptionHandler {
    @SneakyThrows
    override fun handle(exchange: ServerWebExchange, ex: Throwable): Mono<Void> {
        val data: Result = if (ex is ResponseStatusException) Result(ex.status) else Result(INTERNAL_SERVER_ERROR)
        val bytes = mapper.writeValueAsBytes(data)
        val response = exchange.response
        response.headers.contentType = APPLICATION_JSON
        response.headers.contentLength = bytes.size.toLong()
        return response.writeAndFlushWith(just(just(response.bufferFactory().wrap(bytes))))
    }
}
