package org.github.ops.spring

import com.fasterxml.jackson.databind.ObjectMapper
import org.github.spring.bootstrap.AppCtxHolder.Companion.getAppCtx
import org.springframework.beans.BeanWrapperImpl
import org.springframework.cglib.beans.BeanMap.*
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.request.RequestContextHolder.*
import org.springframework.web.context.request.ServletRequestAttributes
import java.io.OutputStream
import kotlin.reflect.KClass

fun <T: Any> ByteArray.toBean(clazz: Class<T>, mapper: ObjectMapper? = null): T = (mapper ?: objectMapper).readValue<T>(this, clazz)

fun <T: Any> ByteArray.toBean(clazz: KClass<T>, mapper: ObjectMapper? = null): T = (mapper ?: objectMapper).readValue<T>(this, clazz.java)

fun <T: Any> Map<String, Any?>.bean(clazz: Class<T>): T = clazz.getDeclaredConstructor().newInstance().also { create(it).putAll(this) }

@Suppress("UNCHECKED_CAST")
val Any.map
  get() = create(this).toMutableMap() as MutableMap<String, Any?>

fun Any?.writeValue(output: OutputStream, mapper: ObjectMapper? = null) = (mapper ?: objectMapper).writeValue(output, this)

val Any.nullProps: Array<String>
  get() {
    val wrapper = BeanWrapperImpl(this)
    return wrapper.propertyDescriptors.asSequence().filter { wrapper.getPropertyValue(it.name) == null }.map { it.name }.toList().toTypedArray()
  }

fun Any?.json(mapper: ObjectMapper? = null): String = (mapper ?: objectMapper).writeValueAsString(this)

val <T: Any> T.proxy get() = appCtx.getBean(this::class.java)

val <T: Any> Class<T>.bean get() = appCtx.getBean(this)

val <T: Any> Class<T>.beans: MutableMap<String, T> get() = appCtx.getBeansOfType(this)

val <T: Any> KClass<T>.bean get() = appCtx.getBean(java)

val <T: Any> KClass<T>.beans: MutableMap<String, T> get() = appCtx.getBeansOfType(java)

val req get() = (getRequestAttributes() as? ServletRequestAttributes)?.request

val resp get() = (getRequestAttributes() as? ServletRequestAttributes)?.response

val appCtx = getAppCtx()

val webAppCtx = appCtx as WebApplicationContext

val objectMapper = appCtx.getBean(ObjectMapper::class.java)

fun <T: Any> String.toBean(clazz: Class<T>, mapper: ObjectMapper? = null): T = (mapper ?: objectMapper).readValue<T>(this, clazz)

fun <T: Any> String.toBean(clazz: KClass<T>, mapper: ObjectMapper? = null): T = (mapper ?: objectMapper).readValue<T>(this, clazz.java)
