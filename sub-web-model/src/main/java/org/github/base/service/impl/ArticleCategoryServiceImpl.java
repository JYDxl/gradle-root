package org.github.base.service.impl;

import org.github.base.entity.ArticleCategoryEntity;
import org.github.base.mapper.IArticleCategoryMapper;
import org.github.base.service.IArticleCategoryService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@Service
public class ArticleCategoryServiceImpl extends ServiceImpl<IArticleCategoryMapper, ArticleCategoryEntity> implements IArticleCategoryService {}
