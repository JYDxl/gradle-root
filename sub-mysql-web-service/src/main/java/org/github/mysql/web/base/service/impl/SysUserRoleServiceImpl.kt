@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.SysUserRoleEntity;
import org.github.mysql.web.base.mapper.ISysUserRoleMapper;
import org.github.mysql.web.base.service.ISysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色对应关系 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-29
 */
@Service
open class SysUserRoleServiceImpl : ServiceImpl<ISysUserRoleMapper, SysUserRoleEntity>(), ISysUserRoleService
