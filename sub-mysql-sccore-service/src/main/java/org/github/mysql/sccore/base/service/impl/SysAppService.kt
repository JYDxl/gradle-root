@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysAppEntity;
import org.github.mysql.sccore.base.mapper.ISysAppMapper;
import org.github.mysql.sccore.base.service.ISysAppService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 应用管理 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysAppService : ServiceImpl<ISysAppMapper, SysAppEntity>(), ISysAppService
