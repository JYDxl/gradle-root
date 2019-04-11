package org.github.ops

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.base.Strings
import com.google.common.io.BaseEncoding
import org.apache.commons.lang3.time.FastDateFormat
import org.github.spring.footstone.FORMAT_DATE
import org.github.spring.footstone.FORMAT_TIME
import kotlin.reflect.KClass

fun String?.padStart(minLength: Int, padChar: Char) = Strings.padStart(this ?: "", minLength, padChar)!!

fun String?.padEnd(minLength: Int, padChar: Char) = Strings.padEnd(this ?: "", minLength, padChar)!!

fun <T: Any> String.toBean(clazz: Class<T>, mapper: ObjectMapper? = null) = (mapper ?: objectMapper).readValue<T>(this, clazz)!!

fun <T: Any> String.toBean(clazz: KClass<T>, mapper: ObjectMapper? = null) = (mapper ?: objectMapper).readValue<T>(this, clazz.java)!!

val String.hexBytes get() = BaseEncoding.base16().decode(toUpperCase())!!

val String.date get() = FastDateFormat.getInstance(FORMAT_DATE).parse(this)!!

val String.time get() = FastDateFormat.getInstance(FORMAT_TIME).parse(this)!!
