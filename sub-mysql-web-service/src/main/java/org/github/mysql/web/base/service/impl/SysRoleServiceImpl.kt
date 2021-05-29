@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.SysRoleEntity;
import org.github.mysql.web.base.mapper.ISysRoleMapper;
import org.github.mysql.web.base.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色 服务实现类
 *
 * @author JYD_XL
 * @since 2021-05-30
 */
@Service
open class SysRoleServiceImpl : ServiceImpl<ISysRoleMapper, SysRoleEntity>(), ISysRoleService
