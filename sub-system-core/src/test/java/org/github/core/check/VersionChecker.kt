package org.github.core.check

import com.google.common.collect.ImmutableMultiset
import com.google.common.collect.ImmutableMultiset.toImmutableMultiset
import org.github.core.ops.log
import org.github.core.ops.warn

fun main() {
  val versions = """"""
  val multiset: ImmutableMultiset<String> = versions.split('\n').stream().map {it.substringBeforeLast(':')}.collect(toImmutableMultiset())
  multiset.forEachEntry {dep: String, count -> if (count > 1) log.warn {dep.substringAfter(':')}}
}

private val log = "main".log
