package org.github.base.service.impl;

import org.github.base.entity.SysConfigEntity;
import org.github.base.mapper.ISysConfigMapper;
import org.github.base.service.ISysConfigService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统配置信息表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@Service
public class SysConfigServiceImpl extends ServiceImpl<ISysConfigMapper, SysConfigEntity> implements ISysConfigService {}
