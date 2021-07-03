package org.github.leadnews.article.dto;

import lombok.*;
import org.github.mysql.leadnews.base.entity.ApArticleEntity;

@EqualsAndHashCode(callSuper = true)
@ToString(callSuper = true)
@Data
public class ArticleHomeLoadVO extends ApArticleEntity {}
