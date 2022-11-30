@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysCodeTypeEntity;
import org.github.mysql.sccore.base.mapper.ISysCodeTypeMapper;
import org.github.mysql.sccore.base.service.ISysCodeTypeService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 码值类型 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysCodeTypeService : ServiceImpl<ISysCodeTypeMapper, SysCodeTypeEntity>(), ISysCodeTypeService
