package org.github.spring.bootstrap

import org.springframework.context.ApplicationContext
import org.springframework.context.ApplicationContextAware
import org.springframework.stereotype.Component

/**
 * ApplicationContext Holder.
 *
 * @author JYD_XL
 */
@Component
class AppCtxHolder: ApplicationContextAware {
  override fun setApplicationContext(applicationContext: ApplicationContext) {
    context = applicationContext
  }

  companion object {
    /** GET ApplicationContext.  */
    fun getAppCtx() = context

    /** ApplicationContext.  */
    private lateinit var context: ApplicationContext
  }
}
