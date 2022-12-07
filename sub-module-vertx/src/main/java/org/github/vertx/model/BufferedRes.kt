package org.github.vertx.model

class BufferedRes: BufferAble, JsonAble() {

  lateinit var cmd: String

  lateinit var result: String

}
