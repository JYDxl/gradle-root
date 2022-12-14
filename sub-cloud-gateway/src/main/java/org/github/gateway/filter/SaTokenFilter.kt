package org.github.gateway.filter

import cn.hutool.core.text.AntPathMatcher
import com.fasterxml.jackson.databind.ObjectMapper
import javax.annotation.Resource
import org.apache.commons.lang3.StringUtils.isBlank
import org.github.core.SA_TOKEN_PREFIX
import org.github.core.TOKEN_NAME
import org.github.core.props.DynamicProperties
import org.github.gateway.dto.Result
import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.core.Ordered
import org.springframework.core.Ordered.HIGHEST_PRECEDENCE
import org.springframework.data.redis.core.ReactiveStringRedisTemplate
import org.springframework.http.HttpStatus.UNAUTHORIZED
import org.springframework.http.MediaType.APPLICATION_JSON
import org.springframework.http.server.reactive.ServerHttpRequest
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono
import reactor.core.publisher.Mono.just
import reactor.core.publisher.Flux.just as fluxJust

@Component
class SaTokenFilter : GlobalFilter, Ordered {
    private val matcher = AntPathMatcher()

    @Resource
    private lateinit var reactiveStringRedisTemplate: ReactiveStringRedisTemplate

    @Resource
    private lateinit var gatewayDynamicProperties: DynamicProperties

    @Resource
    private lateinit var mapper: ObjectMapper

    override fun filter(exchange: ServerWebExchange, chain: GatewayFilterChain): Mono<Void> {
        val request = exchange.request
        return checkWhiteList(request)
            .flatMap { v: Boolean -> checkTokenExists(v, request) }
            .flatMap { v: Boolean -> handle(v, exchange, chain) }
    }

    private fun checkWhiteList(request: ServerHttpRequest): Mono<Boolean> {
        val path = request.path.value()
        for (item: String in gatewayDynamicProperties.whiteList) if (matcher.match("/*$item", path)) return just(true)
        return just(false)
    }

    private fun checkTokenExists(allow: Boolean, request: ServerHttpRequest): Mono<Boolean> {
        if (allow) return just(true)
        val token = request.headers.getFirst(TOKEN_NAME)
        return if (isBlank(token)) just(false) else reactiveStringRedisTemplate.hasKey(SA_TOKEN_PREFIX + token)
    }

    private fun handle(exists: Boolean, exchange: ServerWebExchange, chain: GatewayFilterChain): Mono<Void> {
        if (exists) return chain.filter(exchange)
        val data = Result(UNAUTHORIZED)
        val bytes = mapper.writeValueAsBytes(data)
        val response = exchange.response
        response.headers.contentType = APPLICATION_JSON
        response.headers.contentLength = bytes.size.toLong()
        return response.writeAndFlushWith(fluxJust(fluxJust(response.bufferFactory().wrap(bytes))))
    }

    override fun getOrder(): Int {
        return HIGHEST_PRECEDENCE
    }
}
