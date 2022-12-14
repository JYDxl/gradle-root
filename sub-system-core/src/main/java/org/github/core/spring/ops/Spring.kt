@file:Suppress("unused")

package org.github.core.spring.ops

import cn.dev33.satoken.stp.StpUtil.getLoginId
import cn.hutool.extra.spring.SpringUtil.getApplicationContext
import com.fasterxml.jackson.databind.ObjectMapper
import java.io.OutputStream
import org.springframework.context.ApplicationContext
import org.springframework.web.context.request.RequestContextHolder.getRequestAttributes
import org.springframework.web.context.request.ServletRequestAttributes

fun ObjectMapper.toJson(obj: Any?) = if (obj is String) obj else writeValueAsString(obj)!!

fun Any?.writeValue(output: OutputStream) = objectMapper.writeValue(output, this)

fun Any?.json() = objectMapper.toJson(this)

val <T : Any> T.proxy get() = appCtx.getBean(this::class.java)

val req get() = (getRequestAttributes() as? ServletRequestAttributes)?.request

val resp get() = (getRequestAttributes() as? ServletRequestAttributes)?.response

val user: String get() = getLoginId("system")

val appCtx: ApplicationContext = getApplicationContext()

val objectMapper = appCtx.getBean(ObjectMapper::class.java)
