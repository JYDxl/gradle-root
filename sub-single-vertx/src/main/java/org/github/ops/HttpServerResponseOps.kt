package org.github.ops

import com.google.common.net.MediaType.*
import io.netty.util.AsciiString.*
import io.vertx.core.http.HttpHeaders.*
import io.vertx.core.http.HttpServerResponse

fun HttpServerResponse.json() = putHeader(CONTENT_TYPE, json)

fun HttpServerResponse.text() = putHeader(CONTENT_TYPE, text)

private val json = cached(JSON_UTF_8.toString())

private val text = cached(PLAIN_TEXT_UTF_8.toString())
