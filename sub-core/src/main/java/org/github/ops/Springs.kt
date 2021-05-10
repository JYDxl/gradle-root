package org.github.ops

import org.github.spring.bootstrap.AppCtxHolder.getAppCtx
import org.github.spring.restful.json.JSONMapper
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.request.RequestContextHolder.getRequestAttributes
import org.springframework.web.context.request.ServletRequestAttributes
import java.io.OutputStream

fun Any.writeValue(output: OutputStream, mapper: JSONMapper? = null) = (mapper ?: jsonMapper).writeValue(output, this)

fun Any.json(mapper: JSONMapper? = null): String = (mapper ?: jsonMapper).writeValueAsString(this)

val <T : Any> T.proxy get() = appCtx.getBean(this::class.java)

val req get() = (getRequestAttributes() as? ServletRequestAttributes)?.request

val resp get() = (getRequestAttributes() as? ServletRequestAttributes)?.response

val appCtx = getAppCtx()

val webAppCtx = appCtx as WebApplicationContext

val jsonMapper = appCtx.getBean(JSONMapper::class.java)
