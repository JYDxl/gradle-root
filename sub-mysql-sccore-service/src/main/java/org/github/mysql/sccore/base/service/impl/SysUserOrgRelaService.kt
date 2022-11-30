@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysUserOrgRelaEntity;
import org.github.mysql.sccore.base.mapper.ISysUserOrgRelaMapper;
import org.github.mysql.sccore.base.service.ISysUserOrgRelaService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户与组织之间的数据关系 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysUserOrgRelaService : ServiceImpl<ISysUserOrgRelaMapper, SysUserOrgRelaEntity>(), ISysUserOrgRelaService
