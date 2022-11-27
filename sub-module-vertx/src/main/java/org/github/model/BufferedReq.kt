package org.github.model

class BufferedReq: BufferAble, JsonAble() {

  lateinit var cmd: String

  lateinit var params: String

}
