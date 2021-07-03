package org.github.leadnews.article.controller.v1

import io.swagger.annotations.Api
import io.swagger.annotations.ApiOperation
import org.github.leadnews.article.dto.ArticleHomeLoadBO
import org.github.leadnews.article.dto.ArticleHomeLoadMoreBO
import org.github.leadnews.article.dto.ArticleHomeLoadNewBO
import org.github.leadnews.article.service.IArticleHomeService
import org.github.ops.trim
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.validation.Valid

@Api(tags = ["首页文章管理"])
@RequestMapping("/api/v1/article/")
@RestController
class ArticleHomeController {
  @Autowired
  private lateinit var articleHomeService: IArticleHomeService

  @ApiOperation("加载首页文章")
  @PostMapping("load")
  fun load(@RequestBody @Valid bo: ArticleHomeLoadBO) = articleHomeService.load(bo.trim())

  @ApiOperation("加载更多")
  @PostMapping("load_more")
  fun loadMore(@RequestBody @Valid bo: ArticleHomeLoadMoreBO) = articleHomeService.loadMore(bo.trim())

  @ApiOperation("加载最新")
  @PostMapping("load_new")
  fun loadNew(@RequestBody @Valid bo: ArticleHomeLoadNewBO) = articleHomeService.loadNew(bo.trim())
}
