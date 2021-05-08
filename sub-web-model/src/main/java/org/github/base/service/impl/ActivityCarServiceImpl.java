package org.github.base.service.impl;

import org.github.base.entity.ActivityCarEntity;
import org.github.base.mapper.IActivityCarMapper;
import org.github.base.service.IActivityCarService;
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
public class ActivityCarServiceImpl extends ServiceImpl<IActivityCarMapper, ActivityCarEntity> implements IActivityCarService {}
