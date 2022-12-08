@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.service.impl;

import org.github.mysql.center.entity.SysUserMbpPo;
import org.github.mysql.center.mapper.ISysUserMbpMapper;
import org.github.mysql.center.service.ISysUserMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysUserMbpService : ServiceImpl<ISysUserMbpMapper, SysUserMbpPo>(), ISysUserMbpService
