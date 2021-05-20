package org.github.base.service.impl;

import org.github.base.entity.ArticleTagEntity;
import org.github.base.mapper.IArticleTagMapper;
import org.github.base.service.IArticleTagService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-20
 */
@Service
public class ArticleTagServiceImpl extends ServiceImpl<IArticleTagMapper, ArticleTagEntity> implements IArticleTagService {}
