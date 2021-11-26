package org.github.netty.ops

import io.netty.buffer.ByteBuf

fun ByteBuf.beforeRelease(block: ByteBuf.() -> Unit) = try {
  apply(block)
} finally {
  release()
}
