@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.SysUserEntity;
import org.github.mysql.web.base.mapper.ISysUserMapper;
import org.github.mysql.web.base.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 系统用户 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysUserServiceImpl : ServiceImpl<ISysUserMapper, SysUserEntity>(), ISysUserService
