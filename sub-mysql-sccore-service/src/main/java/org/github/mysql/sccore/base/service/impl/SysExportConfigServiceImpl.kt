@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysExportConfigEntity;
import org.github.mysql.sccore.base.mapper.ISysExportConfigMapper;
import org.github.mysql.sccore.base.service.ISysExportConfigService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 导出配置表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysExportConfigServiceImpl : ServiceImpl<ISysExportConfigMapper, SysExportConfigEntity>(), ISysExportConfigService
