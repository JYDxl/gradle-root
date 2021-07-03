package org.github.leadnews.article.enums

import org.github.base.IEnum

enum class ArticleHomeLoadType(override val code: Int, override val value: String): IEnum<Int, String> {
  LOAD_MORE(1, "加载更多"),
  LOAD_NEW(2, "加载最新");
}
