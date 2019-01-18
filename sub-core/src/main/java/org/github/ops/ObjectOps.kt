package org.github.ops

import com.fasterxml.jackson.databind.ObjectMapper
import com.google.common.annotations.Beta
import org.github.spring.bootstrap.AppCtxHolder
import java.io.OutputStream

@Beta
fun Any?.json(): String? = objectMapper.writeValueAsString(this)

@Beta
fun Any.writeValue(output: OutputStream) = objectMapper.writeValue(output, this)

private val objectMapper = AppCtxHolder.getAppCtx().getBean(ObjectMapper::class.java)
