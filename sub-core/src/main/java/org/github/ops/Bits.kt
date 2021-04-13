package org.github.ops

fun Int.lastN(n: Int) = this and (1 shl n) - 1

fun Long.lastN(n: Int) = this and ((1 shl n) - 1).toLong()
