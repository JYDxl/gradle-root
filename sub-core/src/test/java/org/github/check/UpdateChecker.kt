package org.github.check

import com.google.common.collect.ImmutableSortedSet.toImmutableSortedSet
import org.github.ops.info
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger
import java.util.Comparator.naturalOrder

fun main() {
    val versions = ""
    val set: Set<String> = versions.split('\n').stream()
        .filter { it.contains(" -> ") }
        .map { it.substringAfter(":  - ") }
        .collect(toImmutableSortedSet(naturalOrder()))
    set.forEach { log.info { it } }
}

private val log: Logger = getLogger("main")
