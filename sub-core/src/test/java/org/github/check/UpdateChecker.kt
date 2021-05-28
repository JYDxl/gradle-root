package org.github.check

import com.google.common.collect.ImmutableSet.toImmutableSet
import org.github.ops.info
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger

fun main() {
    val versions = ""
    val multiset: Set<String> = versions.split('\n').stream().filter { it.contains(" -> ") }.collect(toImmutableSet())
    multiset.forEach { log.info { it } }
}

private val log: Logger = getLogger("main")
