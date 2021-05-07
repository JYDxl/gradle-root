package org.github.base.service.impl;

import org.github.base.entity.ActivityKeyEntity;
import org.github.base.mapper.IActivityKeyMapper;
import org.github.base.service.IActivityKeyService;
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
public class ActivityKeyServiceImpl extends ServiceImpl<IActivityKeyMapper, ActivityKeyEntity> implements IActivityKeyService {}
