package org.github.base.service.impl;

import org.github.base.entity.SdkInterfaceEntity;
import org.github.base.mapper.ISdkInterfaceMapper;
import org.github.base.service.ISdkInterfaceService;
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
public class SdkInterfaceServiceImpl extends ServiceImpl<ISdkInterfaceMapper, SdkInterfaceEntity> implements ISdkInterfaceService {}
