@file:Suppress("unused")

package org.github.spring.ops

import cn.hutool.extra.spring.SpringUtil.getApplicationContext
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.context.ApplicationContext
import org.springframework.core.io.Resource
import org.springframework.web.context.request.RequestContextHolder.getRequestAttributes
import org.springframework.web.context.request.ServletRequestAttributes
import java.io.OutputStream

fun Any?.writeValue(output: OutputStream) = objectMapper.writeValue(output, this)

fun Any?.json(): String = objectMapper.writeValueAsString(this)

val <T: Any> T.proxy get() = appCtx.getBean(this::class.java)

val req get() = (getRequestAttributes() as? ServletRequestAttributes)?.request

val resp get() = (getRequestAttributes() as? ServletRequestAttributes)?.response

val appCtx: ApplicationContext = getApplicationContext()

val objectMapper = appCtx.getBean(ObjectMapper::class.java)

fun ApplicationContext.ktGetResources(locationPattern: String): Array<Resource> = getResources(locationPattern)
