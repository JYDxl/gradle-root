package org.github.ops

import com.fasterxml.jackson.databind.ObjectMapper
import org.github.spring.bootstrap.AppCtxHolder
import java.io.OutputStream

fun Any?.json() = objectMapper.writeValueAsString(this)!!

fun Any.writeValue(output: OutputStream) = objectMapper.writeValue(output, this)

private val objectMapper = AppCtxHolder.getAppCtx().getBean(ObjectMapper::class.java)
