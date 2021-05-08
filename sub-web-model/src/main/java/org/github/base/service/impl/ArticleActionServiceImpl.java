package org.github.base.service.impl;

import org.github.base.entity.ArticleActionEntity;
import org.github.base.mapper.IArticleActionMapper;
import org.github.base.service.IArticleActionService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-08
 */
@Service
public class ArticleActionServiceImpl extends ServiceImpl<IArticleActionMapper, ArticleActionEntity> implements IArticleActionService {}
