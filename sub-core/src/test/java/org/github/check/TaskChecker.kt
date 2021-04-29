package org.github.check

import org.github.ops.info
import org.github.ops.log
import org.github.ops.trace

fun main() {
  val tasks = ""
  val map = tasks.splitToSequence('\n').filter {it.startsWith("> Task :")}.map {Task(it.substringBeforeLast(':'), it.substringAfterLast(':'), it)}.groupBy {it.name}
  map.forEach {(task, list) ->
    log.info {task}
    list.forEach {log.info {it.detail}}
    log.trace {""}
  }
}

data class Task(val name: String, val detail: String, val original: String)

private val log = Task::class.log
