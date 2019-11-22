package org.github.protobuf.ops

import com.google.protobuf.Message
import com.google.protobuf.util.JsonFormat.*

val Message.json get() = printer().print(this)!!
