package org.github

import com.google.common.collect.HashMultiset

fun main() {
  val versions = ""
  val list = versions.splitToSequence('\n').map {it.substringBeforeLast(':')}.toList()
  val multiset: HashMultiset<String> = HashMultiset.create(list)
  multiset.forEachEntry {dep: String, count -> if (count > 1) println("${dep.substringAfter(':')}:")}
}
