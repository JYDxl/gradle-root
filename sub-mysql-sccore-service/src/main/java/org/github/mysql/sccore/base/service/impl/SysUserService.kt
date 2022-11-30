@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysUserEntity;
import org.github.mysql.sccore.base.mapper.ISysUserMapper;
import org.github.mysql.sccore.base.service.ISysUserService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户管理 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysUserService : ServiceImpl<ISysUserMapper, SysUserEntity>(), ISysUserService
