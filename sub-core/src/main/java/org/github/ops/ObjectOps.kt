package org.github.ops

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.base.Throwables
import org.github.spring.bootstrap.AppCtxHolder.Companion.getAppCtx
import org.github.spring.restful.Returnable
import org.springframework.beans.BeanWrapperImpl
import org.springframework.cglib.beans.BeanMap.*
import org.springframework.web.context.WebApplicationContext
import org.springframework.web.context.request.RequestContextHolder.*
import org.springframework.web.context.request.ServletRequestAttributes
import java.io.Closeable
import java.io.IOException
import java.io.OutputStream
import kotlin.reflect.KClass

fun Any?.writeValue(output: OutputStream, mapper: ObjectMapper? = null) = (mapper ?: objectMapper).writeValue(output, this)

@Suppress("UNCHECKED_CAST")
val Any.map
  get() = create(this).toMutableMap() as MutableMap<String, Any?>

val Any.nullProps: Array<String>
  get() {
    val wrapper = BeanWrapperImpl(this)
    return wrapper.propertyDescriptors.asSequence().filter { wrapper.getPropertyValue(it.name) == null }.map { it.name!! }.toList().toTypedArray()
  }

fun Any?.json(mapper: ObjectMapper? = null) = (mapper ?: objectMapper).writeValueAsString(this)!!

fun Closeable?.closeQuietly() = this?.let {
  try {
    it.close()
  } catch(ignore: IOException) {
  }
}

val <T: Any> T.proxy get() = appCtx.getBean(this::class.java)

val Returnable.value get() = get()

val Exception.rootCause get() = Throwables.getRootCause(this)!!

val <T: Any> Class<T>.bean get() = appCtx.getBean(this)

val <T: Any> Class<T>.beans: MutableMap<String, T> get() = appCtx.getBeansOfType(this)

val <T: Any> KClass<T>.bean get() = appCtx.getBean(java)

val <T: Any> KClass<T>.beans: MutableMap<String, T> get() = appCtx.getBeansOfType(java)

val req get() = (getRequestAttributes() as? ServletRequestAttributes)?.request

val resp get() = (getRequestAttributes() as? ServletRequestAttributes)?.response

val appCtx = getAppCtx()

val webAppCtx = appCtx as WebApplicationContext

val objectMapper = appCtx.getBean(ObjectMapper::class.java)
