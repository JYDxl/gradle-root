package org.github.thread

import java.lang.System.getSecurityManager
import java.lang.Thread.NORM_PRIORITY
import java.lang.Thread.currentThread
import java.util.concurrent.ThreadFactory
import java.util.concurrent.atomic.AtomicInteger

class NaiveThreadFactory(private val prefix: String) : ThreadFactory {
  private val number = AtomicInteger(0)
  private val group: ThreadGroup

  init {
    val manager: SecurityManager? = getSecurityManager()
    group = if(manager != null) manager.threadGroup else currentThread().threadGroup
  }

  override fun newThread(runnable: Runnable) = Thread(group, runnable, "$prefix-${number.getAndIncrement()}", 0).apply {
    if(isDaemon) isDaemon = false
    if(priority != NORM_PRIORITY) priority = NORM_PRIORITY
  }
}
