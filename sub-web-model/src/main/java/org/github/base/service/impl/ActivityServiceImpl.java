package org.github.base.service.impl;

import org.github.base.entity.ActivityEntity;
import org.github.base.mapper.IActivityMapper;
import org.github.base.service.IActivityService;
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
public class ActivityServiceImpl extends ServiceImpl<IActivityMapper, ActivityEntity> implements IActivityService {}
