package org.github.leadnews.article.service.impl

import org.github.base.IPage
import org.github.base.Page
import org.github.leadnews.article.dto.ArticleHomeLoadBO
import org.github.leadnews.article.dto.ArticleHomeLoadMoreBO
import org.github.leadnews.article.dto.ArticleHomeLoadNewBO
import org.github.leadnews.article.dto.ArticleHomeLoadVO
import org.github.leadnews.article.mapper.IArticleHomeMapper
import org.github.leadnews.article.service.IArticleHomeService
import org.github.mybatis.ops.ktQueryWrapper
import org.github.mysql.leadnews.base.entity.ApUserArticleListEntity
import org.github.mysql.leadnews.base.service.IApUserArticleListService
import org.github.shiro.User
import org.github.shiro.ops.userOrNull
import org.github.spring.restful.json.JSONPageReturn
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ArticleHomeServiceImpl: IArticleHomeService {
  @Autowired
  private lateinit var articleHomeMapper: IArticleHomeMapper

  @Autowired
  private lateinit var apUserArticleListService: IApUserArticleListService

  override fun load(bo: ArticleHomeLoadBO): JSONPageReturn<ArticleHomeLoadVO> {
    val user = userOrNull
    return if (user != null) getUserArticle(bo, user) else getDefaultArticle(bo)
  }

  private fun getUserArticle(bo: ArticleHomeLoadBO, user: User): JSONPageReturn<ArticleHomeLoadVO> {
    val query = apUserArticleListService.ktQueryWrapper()
    query.eq(ApUserArticleListEntity::userId, user.id)
    query.select(ApUserArticleListEntity::articleId)
    val articleIdList = query.list().map {it.articleId!!}
    bo.articleIdList = articleIdList

    return getDefaultArticle(bo)
  }

  private fun getDefaultArticle(bo: ArticleHomeLoadBO): JSONPageReturn<ArticleHomeLoadVO> {
    val page: IPage<ArticleHomeLoadVO> = articleHomeMapper.getDefaultArticle(Page(bo), bo)
    return JSONPageReturn.of(page)
  }

  override fun loadMore(bo: ArticleHomeLoadMoreBO): JSONPageReturn<ArticleHomeLoadVO> {
    return load(bo)
  }

  override fun loadNew(bo: ArticleHomeLoadNewBO): JSONPageReturn<ArticleHomeLoadVO> {
    return load(bo)
  }
}
