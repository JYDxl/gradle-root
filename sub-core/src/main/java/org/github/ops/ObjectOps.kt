package org.github.ops

val <T: Any> T?.requireNotNull: T get() = requireNotNull(this)
