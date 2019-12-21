package org.github.ops

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.base.Strings
import com.google.common.io.BaseEncoding.*
import org.apache.commons.lang3.time.FastDateFormat
import org.github.spring.footstone.FORMAT_DATE
import org.github.spring.footstone.FORMAT_TIME
import java.io.File
import java.lang.ClassLoader.*
import java.util.Date
import kotlin.reflect.KClass

fun String?.padStart(minLength: Int, padChar: Char): String = Strings.padStart(this ?: "", minLength, padChar)

fun String?.padEnd(minLength: Int, padChar: Char): String = Strings.padEnd(this ?: "", minLength, padChar)

fun <T: Any> String.toBean(clazz: Class<T>, mapper: ObjectMapper? = null): T = (mapper ?: objectMapper).readValue<T>(this, clazz)

fun <T: Any> String.toBean(clazz: KClass<T>, mapper: ObjectMapper? = null): T = (mapper ?: objectMapper).readValue<T>(this, clazz.java)

val String.hexBytes: ByteArray get() = base16().decode(toUpperCase())

val String.date: Date get() = FastDateFormat.getInstance(FORMAT_DATE).parse(this)

val String.time: Date get() = FastDateFormat.getInstance(FORMAT_TIME).parse(this)

val String.classpathFile get() = File(getSystemResource(this).file)
