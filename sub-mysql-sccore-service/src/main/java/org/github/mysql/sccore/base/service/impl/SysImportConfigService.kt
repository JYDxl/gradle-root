@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysImportConfigEntity;
import org.github.mysql.sccore.base.mapper.ISysImportConfigMapper;
import org.github.mysql.sccore.base.service.ISysImportConfigService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 导入出配置表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysImportConfigService : ServiceImpl<ISysImportConfigMapper, SysImportConfigEntity>(), ISysImportConfigService
