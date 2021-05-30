package org.github.check

import com.google.common.collect.ImmutableMultiset.toImmutableMultiset
import com.google.common.collect.Multiset
import org.github.ops.warn
import org.slf4j.Logger
import org.slf4j.LoggerFactory.getLogger

fun main() {
  val versions = """"""
  val multiset: Multiset<String> = versions.split('\n').stream().map {it.substringBeforeLast(':')}.collect(toImmutableMultiset())
  multiset.forEachEntry {dep: String, count -> if (count > 1) log.warn {dep.substringAfter(':')}}
}

private val log: Logger = getLogger("main")
