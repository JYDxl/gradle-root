package org.github.base.service.impl;

import org.github.base.entity.SysOrgEntity;
import org.github.base.mapper.ISysOrgMapper;
import org.github.base.service.ISysOrgService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统-组织表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-05-07
 */
@Service
public class SysOrgServiceImpl extends ServiceImpl<ISysOrgMapper, SysOrgEntity> implements ISysOrgService {}
