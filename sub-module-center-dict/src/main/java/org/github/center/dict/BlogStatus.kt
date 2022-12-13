@file:Suppress("unused")

package org.github.center.dict

import org.github.core.base.BaseEnum

/**
 * 博客状态 
 *
 * @author JYD_XL
 */
enum class BlogStatus(override val code: String, override val value: String): BaseEnum {
  /** 待发布  */
  TO_BE_RELEASED("TO_BE_RELEASED","待发布"),
  ;

  companion object {
    const val BLOG_STATUS : String = "BlogStatus"
  }
}
