package org.github.ops

import com.google.common.base.Strings.*
import com.google.common.io.BaseEncoding.*
import org.apache.commons.lang3.time.FastDateFormat.*
import org.github.spring.footstone.FORMAT_DATE
import org.github.spring.footstone.FORMAT_DATE_TIME
import java.io.File
import java.lang.ClassLoader.*
import java.util.Date

fun String.padStart(minLength: Int, padChar: Char): String = padStart(this, minLength, padChar)

fun String.padEnd(minLength: Int, padChar: Char): String = padEnd(this, minLength, padChar)

val String.hexBytes: ByteArray get() = base16().decode(toUpperCase())

val String.date: Date get() = getInstance(FORMAT_DATE).parse(this)

val String.time: Date get() = getInstance(FORMAT_DATE_TIME).parse(this)

val String.classpathFile get() = File(getSystemResource(this).file)
