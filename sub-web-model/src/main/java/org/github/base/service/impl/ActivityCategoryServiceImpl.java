package org.github.base.service.impl;

import org.github.base.entity.ActivityCategoryEntity;
import org.github.base.mapper.IActivityCategoryMapper;
import org.github.base.service.IActivityCategoryService;
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
public class ActivityCategoryServiceImpl extends ServiceImpl<IActivityCategoryMapper, ActivityCategoryEntity> implements IActivityCategoryService {}
