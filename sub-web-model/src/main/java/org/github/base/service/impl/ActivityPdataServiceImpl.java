package org.github.base.service.impl;

import org.github.base.entity.ActivityPdataEntity;
import org.github.base.mapper.IActivityPdataMapper;
import org.github.base.service.IActivityPdataService;
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
public class ActivityPdataServiceImpl extends ServiceImpl<IActivityPdataMapper, ActivityPdataEntity> implements IActivityPdataService {}
