package org.github.spring.restful.json

import com.fasterxml.jackson.databind.ObjectMapper
import java.io.InputStream
import java.io.OutputStream

class JSONMapperImpl(private val mapper: ObjectMapper) : JSONMapper {
    override fun writeValueAsString(any: Any): String = mapper.writeValueAsString(any)

    override fun writeValue(output: OutputStream, any: Any) = mapper.writeValue(output, any)

    override fun <T : Any> readValue(input: InputStream, type: Class<T>): T = mapper.readValue(input, type)
}
