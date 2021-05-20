package org.github.base.service.impl;

import org.github.base.entity.SdkInterfaceInfoEntity;
import org.github.base.mapper.ISdkInterfaceInfoMapper;
import org.github.base.service.ISdkInterfaceInfoService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-20
 */
@Service
public class SdkInterfaceInfoServiceImpl extends ServiceImpl<ISdkInterfaceInfoMapper, SdkInterfaceInfoEntity> implements ISdkInterfaceInfoService {}
