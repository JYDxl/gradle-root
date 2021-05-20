package org.github.base.service.impl;

import org.github.base.entity.SdkTempEntity;
import org.github.base.mapper.ISdkTempMapper;
import org.github.base.service.ISdkTempService;
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
public class SdkTempServiceImpl extends ServiceImpl<ISdkTempMapper, SdkTempEntity> implements ISdkTempService {}
