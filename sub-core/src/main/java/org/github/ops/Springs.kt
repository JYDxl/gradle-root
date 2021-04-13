package org.github.ops

import com.fasterxml.jackson.databind.ObjectMapper
import org.github.spring.bootstrap.AppCtxHolder.Companion.getAppCtx
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.request.RequestContextHolder.getRequestAttributes
import org.springframework.web.context.request.ServletRequestAttributes
import java.io.OutputStream

fun Any?.writeValue(output: OutputStream, mapper: ObjectMapper? = null) = (mapper ?: objectMapper).writeValue(output, this)

fun Any?.json(mapper: ObjectMapper? = null): String = (mapper ?: objectMapper).writeValueAsString(this)

val <T: Any> T.proxy get() = appCtx.getBean(this::class.java)

val req get() = (getRequestAttributes() as? ServletRequestAttributes)?.request

val resp get() = (getRequestAttributes() as? ServletRequestAttributes)?.response

val appCtx = getAppCtx()

val webAppCtx = appCtx as WebApplicationContext

val objectMapper = appCtx.getBean(ObjectMapper::class.java)
