@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.SysUserMbpEntity;
import org.github.mysql.center.base.mapper.ISysUserMbpMapper;
import org.github.mysql.center.base.service.ISysUserMbpService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysUserMbpService : ServiceImpl<ISysUserMbpMapper, SysUserMbpEntity>(), ISysUserMbpService
