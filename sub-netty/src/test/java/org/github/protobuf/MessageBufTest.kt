package org.github.protobuf

import org.github.ops.json
import org.github.protobuf.MessageBuf.*
import org.junit.jupiter.api.Test

class MessageBufTest {
  @Test
  fun test() {
    val param = Student.newBuilder().apply {
      name = "张三"
      age = 20
      address = "北京"
    }.build()!!
    println(param.json)
    val bytes = param.toByteArray()!!
    val result = Student.parseFrom(bytes)!!
    println(result.json)
  }
}
