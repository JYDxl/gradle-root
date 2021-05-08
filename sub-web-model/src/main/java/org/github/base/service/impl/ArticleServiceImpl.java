package org.github.base.service.impl;

import org.github.base.entity.ArticleEntity;
import org.github.base.mapper.IArticleMapper;
import org.github.base.service.IArticleService;
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
public class ArticleServiceImpl extends ServiceImpl<IArticleMapper, ArticleEntity> implements IArticleService {}
