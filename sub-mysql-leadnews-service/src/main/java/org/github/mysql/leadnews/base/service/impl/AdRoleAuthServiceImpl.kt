@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdRoleAuthEntity;
import org.github.mysql.leadnews.base.mapper.IAdRoleAuthMapper;
import org.github.mysql.leadnews.base.service.IAdRoleAuthService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色权限信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdRoleAuthServiceImpl : ServiceImpl<IAdRoleAuthMapper, AdRoleAuthEntity>(), IAdRoleAuthService
