package org.github.vertx.ops

import com.google.common.net.MediaType.JSON_UTF_8
import com.google.common.net.MediaType.PLAIN_TEXT_UTF_8
import io.netty.util.AsciiString.cached
import io.vertx.core.http.HttpHeaders.CONTENT_TYPE
import io.vertx.core.http.HttpServerResponse

fun HttpServerResponse.json(): HttpServerResponse = putHeader(CONTENT_TYPE, json)

fun HttpServerResponse.text(): HttpServerResponse = putHeader(CONTENT_TYPE, text)

private val json = cached(JSON_UTF_8.toString())

private val text = cached(PLAIN_TEXT_UTF_8.toString())
