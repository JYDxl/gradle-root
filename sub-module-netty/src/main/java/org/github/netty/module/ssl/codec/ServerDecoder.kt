package org.github.netty.module.ssl.codec

import io.netty.channel.ChannelHandler.*
import io.netty.handler.codec.string.StringDecoder
import java.nio.charset.Charset
import kotlin.text.Charsets.UTF_8

@Sharable
class ServerDecoder(charset: Charset = UTF_8): StringDecoder(charset)
