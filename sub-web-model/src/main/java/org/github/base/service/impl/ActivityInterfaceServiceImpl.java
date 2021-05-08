package org.github.base.service.impl;

import org.github.base.entity.ActivityInterfaceEntity;
import org.github.base.mapper.IActivityInterfaceMapper;
import org.github.base.service.IActivityInterfaceService;
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
public class ActivityInterfaceServiceImpl extends ServiceImpl<IActivityInterfaceMapper, ActivityInterfaceEntity> implements IActivityInterfaceService {}
