package org.github.leadnews.article.service

import org.github.leadnews.article.dto.ArticleHomeLoadBO
import org.github.leadnews.article.dto.ArticleHomeLoadMoreBO
import org.github.leadnews.article.dto.ArticleHomeLoadNewBO
import org.github.leadnews.article.dto.ArticleHomeLoadVO
import org.github.spring.restful.json.JSONPageReturn

interface IArticleHomeService {
  fun load(bo: ArticleHomeLoadBO): JSONPageReturn<ArticleHomeLoadVO>

  fun loadMore(bo: ArticleHomeLoadMoreBO): JSONPageReturn<ArticleHomeLoadVO>

  fun loadNew(bo: ArticleHomeLoadNewBO): JSONPageReturn<ArticleHomeLoadVO>
}
