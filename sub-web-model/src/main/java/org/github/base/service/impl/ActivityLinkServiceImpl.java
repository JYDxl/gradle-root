package org.github.base.service.impl;

import org.github.base.entity.ActivityLinkEntity;
import org.github.base.mapper.IActivityLinkMapper;
import org.github.base.service.IActivityLinkService;
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
public class ActivityLinkServiceImpl extends ServiceImpl<IActivityLinkMapper, ActivityLinkEntity> implements IActivityLinkService {}
