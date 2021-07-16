package org.github.leadnews.article.mapper;

import org.github.base.IPage;
import org.github.leadnews.article.dto.ArticleHomeLoadBO;
import org.github.leadnews.article.dto.ArticleHomeLoadVO;
import org.github.mybatis.MyBatisMapper;
import org.jetbrains.annotations.NotNull;

@MyBatisMapper
public interface IArticleHomeMapper {
  @NotNull IPage<ArticleHomeLoadVO> getDefaultArticle(IPage<ArticleHomeLoadVO> page, ArticleHomeLoadBO bo);
}
