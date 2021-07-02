@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdRoleEntity;
import org.github.mysql.leadnews.base.mapper.IAdRoleMapper;
import org.github.mysql.leadnews.base.service.IAdRoleService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdRoleServiceImpl : ServiceImpl<IAdRoleMapper, AdRoleEntity>(), IAdRoleService
