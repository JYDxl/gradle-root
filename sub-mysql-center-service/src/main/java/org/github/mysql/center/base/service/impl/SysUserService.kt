@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.SysUserEntity;
import org.github.mysql.center.base.mapper.ISysUserMapper;
import org.github.mysql.center.base.service.ISysUserService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysUserService : ServiceImpl<ISysUserMapper, SysUserEntity>(), ISysUserService
