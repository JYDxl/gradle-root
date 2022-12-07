package org.github.core.check

import org.github.core.ops.info
import org.github.core.ops.log
import org.github.core.ops.trace

fun main() {
  val tasks = """"""
  val map = tasks.splitToSequence('\n').filter {it.startsWith("> Task :")}.map { Task(it.substringBeforeLast(':'), it.substringAfterLast(':'), it) }.groupBy {it.name}
  map.forEach {(task, list) ->
    log.info {task}
    list.forEach { log.info {it.detail}}
    log.trace {""}
  }
}

data class Task(val name: String, val detail: String, val original: String)

private val log = Task::class.log
