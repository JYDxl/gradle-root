package org.github.base.service.impl;

import org.github.base.entity.SdkInterfaceTypeEntity;
import org.github.base.mapper.ISdkInterfaceTypeMapper;
import org.github.base.service.ISdkInterfaceTypeService;
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
public class SdkInterfaceTypeServiceImpl extends ServiceImpl<ISdkInterfaceTypeMapper, SdkInterfaceTypeEntity> implements ISdkInterfaceTypeService {}
