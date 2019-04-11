package org.github.ops

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.io.BaseEncoding
import kotlin.reflect.KClass

val ByteArray.hexStr get() = BaseEncoding.base16().encode(this)!!

fun <T: Any> ByteArray.toBean(clazz: Class<T>, mapper: ObjectMapper? = null) = (mapper ?: objectMapper).readValue<T>(this, clazz)!!

fun <T: Any> ByteArray.toBean(clazz: KClass<T>, mapper: ObjectMapper? = null) = (mapper ?: objectMapper).readValue<T>(this, clazz.java)!!
