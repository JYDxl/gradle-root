@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysCodeEntity;
import org.github.mysql.sccore.base.mapper.ISysCodeMapper;
import org.github.mysql.sccore.base.service.ISysCodeService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 数据字典表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysCodeService : ServiceImpl<ISysCodeMapper, SysCodeEntity>(), ISysCodeService
