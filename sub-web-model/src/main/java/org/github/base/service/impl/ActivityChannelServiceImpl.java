package org.github.base.service.impl;

import org.github.base.entity.ActivityChannelEntity;
import org.github.base.mapper.IActivityChannelMapper;
import org.github.base.service.IActivityChannelService;
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
public class ActivityChannelServiceImpl extends ServiceImpl<IActivityChannelMapper, ActivityChannelEntity> implements IActivityChannelService {}
