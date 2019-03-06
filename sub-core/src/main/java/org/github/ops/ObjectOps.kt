package org.github.ops

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.base.Strings.padEnd
import com.google.common.base.Strings.padStart
import org.github.spring.bootstrap.AppCtxHolder.Companion.getAppCtx
import org.github.spring.footstone.EMPTY
import org.springframework.cglib.beans.BeanMap.create
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.request.RequestContextHolder.getRequestAttributes
import org.springframework.web.context.request.ServletRequestAttributes
import java.io.OutputStream

fun Any?.writeValue(output: OutputStream) = objectMapper.writeValue(output, this)

fun String?.padStart(minLength: Int, padChar: Char) = padStart(this ?: EMPTY, minLength, padChar)!!

fun String?.padEnd(minLength: Int, padChar: Char) = padEnd(this ?: EMPTY, minLength, padChar)!!

fun <T: Any> Map<String, Any?>.bean(clazz: Class<T>) = clazz.getDeclaredConstructor().newInstance()!!.also { create(it).putAll(this) }

@Suppress("UNCHECKED_CAST")
val Any.map get() = create(this).toMutableMap() as MutableMap<String, Any?>

val Any?.json get() = objectMapper.writeValueAsString(this)!!

val <T: Any> T.proxy get() = appCtx.getBean(this::class.java)

val appCtx get() = getAppCtx()

val objectMapper get() = appCtx.getBean(ObjectMapper::class.java)

val webAppCtx get() = appCtx as WebApplicationContext

val req get() = (getRequestAttributes() as? ServletRequestAttributes)?.request

val resp get() = (getRequestAttributes() as? ServletRequestAttributes)?.response
