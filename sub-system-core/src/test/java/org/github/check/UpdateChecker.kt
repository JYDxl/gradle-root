package org.github.check

import com.google.common.collect.ImmutableSortedSet
import com.google.common.collect.ImmutableSortedSet.toImmutableSortedSet
import org.github.ops.info
import org.github.ops.log
import java.util.Comparator.naturalOrder

fun main() {
  val updates = """"""
  val sortedSet: ImmutableSortedSet<String> = updates.split('\n').stream().filter {it.contains(" -> ")}.collect(toImmutableSortedSet(naturalOrder()))
  sortedSet.forEach {log.info {it}}
}

private val log = "main".log
