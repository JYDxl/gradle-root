package org.github.module.log

import java.net.InetSocketAddress

data class LogEvent(val addr: InetSocketAddress, val file: String, val msg: String)
