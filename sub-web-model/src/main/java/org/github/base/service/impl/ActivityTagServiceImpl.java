package org.github.base.service.impl;

import org.github.base.entity.ActivityTagEntity;
import org.github.base.mapper.IActivityTagMapper;
import org.github.base.service.IActivityTagService;
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
public class ActivityTagServiceImpl extends ServiceImpl<IActivityTagMapper, ActivityTagEntity> implements IActivityTagService {}
