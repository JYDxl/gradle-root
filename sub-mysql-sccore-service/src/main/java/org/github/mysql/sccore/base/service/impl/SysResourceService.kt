@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysResourceEntity;
import org.github.mysql.sccore.base.mapper.ISysResourceMapper;
import org.github.mysql.sccore.base.service.ISysResourceService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 资源接口管理 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysResourceService : ServiceImpl<ISysResourceMapper, SysResourceEntity>(), ISysResourceService
