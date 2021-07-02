@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdUserRoleEntity;
import org.github.mysql.leadnews.base.mapper.IAdUserRoleMapper;
import org.github.mysql.leadnews.base.service.IAdUserRoleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 管理员角色信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdUserRoleServiceImpl : ServiceImpl<IAdUserRoleMapper, AdUserRoleEntity>(), IAdUserRoleService
