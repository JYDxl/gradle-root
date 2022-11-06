@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysOrgEntity;
import org.github.mysql.sccore.base.mapper.ISysOrgMapper;
import org.github.mysql.sccore.base.service.ISysOrgService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 区域表，行政数据 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysOrgServiceImpl : ServiceImpl<ISysOrgMapper, SysOrgEntity>(), ISysOrgService
