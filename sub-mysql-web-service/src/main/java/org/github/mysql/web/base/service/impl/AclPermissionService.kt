@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.AclPermissionEntity;
import org.github.mysql.web.base.mapper.IAclPermissionMapper;
import org.github.mysql.web.base.service.IAclPermissionService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 权限 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AclPermissionService : ServiceImpl<IAclPermissionMapper, AclPermissionEntity>(), IAclPermissionService
