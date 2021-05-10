package org.github.spring.restful.json

import java.io.InputStream
import java.io.OutputStream

interface JSONMapper {
    fun writeValueAsString(any: Any): String

    fun writeValue(output: OutputStream, any: Any)

    fun <T : Any> readValue(input: InputStream, type: Class<T>): T
}
