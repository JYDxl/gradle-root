package org.github

import org.github.ops.info
import org.github.ops.log

fun main() {
  val tasks = ""
  val map = tasks.splitToSequence('\n').map {Task(it.substringBeforeLast(':'), it.substringAfterLast(':'), it)}.groupBy {it.name}
  map.forEach {(task, list) ->
    log.info {task}
    list.forEach {log.info {it.detail}}
    log.info {""}
  }
}

data class Task(val name: String, val detail: String, val original: String)

private val log = Task::class.log
