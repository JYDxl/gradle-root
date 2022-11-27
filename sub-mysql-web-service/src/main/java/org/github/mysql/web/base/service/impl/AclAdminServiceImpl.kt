@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.AclAdminEntity;
import org.github.mysql.web.base.mapper.IAclAdminMapper;
import org.github.mysql.web.base.service.IAclAdminService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AclAdminServiceImpl : ServiceImpl<IAclAdminMapper, AclAdminEntity>(), IAclAdminService
