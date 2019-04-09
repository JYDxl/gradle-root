package org.github.ops

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.base.Strings.padEnd
import com.google.common.base.Strings.padStart
import com.google.common.io.BaseEncoding.base16
import org.apache.commons.lang3.time.FastDateFormat.getInstance
import org.github.spring.bootstrap.AppCtxHolder.Companion.getAppCtx
import org.github.spring.footstone.EMPTY
import org.github.spring.footstone.FORMAT_DATE
import org.github.spring.footstone.FORMAT_TIME
import org.github.spring.restful.Returnable
import org.springframework.beans.BeanWrapperImpl
import org.springframework.cglib.beans.BeanMap.create
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.request.RequestContextHolder.getRequestAttributes
import org.springframework.web.context.request.ServletRequestAttributes
import java.io.OutputStream
import java.time.LocalDateTime
import java.time.LocalTime
import java.time.ZoneId.systemDefault
import java.util.Date.from

fun Any?.writeValue(output: OutputStream) = objectMapper.writeValue(output, this)

fun String?.padStart(minLength: Int, padChar: Char) = padStart(this ?: EMPTY, minLength, padChar)!!

fun String?.padEnd(minLength: Int, padChar: Char) = padEnd(this ?: EMPTY, minLength, padChar)!!

fun <T: Any> Map<String, Any?>.bean(clazz: Class<T>) = clazz.getDeclaredConstructor().newInstance()!!.also { create(it).putAll(this) }

@Suppress("UNCHECKED_CAST")
val Any.map
  get() = create(this).toMutableMap() as MutableMap<String, Any?>

val Any.nullProps: Array<String>
  get() {
    val wrapper = BeanWrapperImpl(this)
    return wrapper.propertyDescriptors.asSequence().filter { wrapper.getPropertyValue(it.name) == null }.map { it.name!! }.toList().toTypedArray()
  }

val Any?.json get() = objectMapper.writeValueAsString(this)!!

val <T: Any> T.proxy get() = appCtx.getBean(this::class.java)

val String.hexBytes get() = base16().decode(toUpperCase())!!

val String.date get() = getInstance(FORMAT_DATE).parse(this)!!

val String.time get() = getInstance(FORMAT_TIME).parse(this)!!

val LocalDateTime.value get() = "${toLocalDate()} ${toLocalTime().withNano(0)}"

val LocalDateTime.instant get() = atZone(systemDefault()).toInstant()!!

val LocalDateTime.date get() = from(instant)!!

val LocalDateTime.long get() = instant.toEpochMilli()

val LocalDateTime.seconds get() = instant.epochSecond

val LocalTime.value get() = withNano(0).toString()

val LocalTime.minOfDay get() = this.toSecondOfDay() / 60

val ByteArray.hexStr get() = base16().encode(this)!!

val Returnable.value get() = get()

val req get() = (getRequestAttributes() as? ServletRequestAttributes)?.request

val resp get() = (getRequestAttributes() as? ServletRequestAttributes)?.response

val appCtx = getAppCtx()

val webAppCtx = appCtx as WebApplicationContext

val objectMapper = appCtx.getBean(ObjectMapper::class.java)
