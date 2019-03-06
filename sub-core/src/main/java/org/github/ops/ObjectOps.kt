package org.github.ops

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.base.Strings.padEnd
import com.google.common.base.Strings.padStart
import org.github.spring.bootstrap.AppCtxHolder
import org.github.spring.footstone.EMPTY
import org.springframework.cglib.beans.BeanMap
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.request.RequestContextHolder
import org.springframework.web.context.request.ServletRequestAttributes
import java.io.OutputStream

fun Any?.writeValue(output: OutputStream) = objectMapper.writeValue(output, this)

fun <T : Any> Map<String, Any?>.bean(clazz: Class<T>) = clazz.getDeclaredConstructor().newInstance()!!.also { BeanMap.create(it).putAll(this) }

//TODO hanjian 待测试
fun String?.padStart(minLength: Int, padChar: Char) = padStart(this ?: EMPTY, minLength, padChar)!!

//TODO hanjian 待测试
fun String?.padEnd(minLength: Int, padChar: Char) = padEnd(this ?: EMPTY, minLength, padChar)!!

val Any?.json get() = objectMapper.writeValueAsString(this)!!

val req get() = (RequestContextHolder.getRequestAttributes() as? ServletRequestAttributes)?.request

val resp get() = (RequestContextHolder.getRequestAttributes() as? ServletRequestAttributes)?.response

@Suppress("UNCHECKED_CAST")
val Any.map get() = BeanMap.create(this).toMutableMap() as MutableMap<String, Any?>

val objectMapper get() = AppCtxHolder.getAppCtx().getBean(ObjectMapper::class.java)

val webAppCtx get() = AppCtxHolder.getAppCtx() as WebApplicationContext

val appCtx get() = AppCtxHolder.getAppCtx()
