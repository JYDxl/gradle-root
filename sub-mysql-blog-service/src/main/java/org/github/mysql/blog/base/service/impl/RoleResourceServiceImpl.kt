@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.RoleResourceEntity;
import org.github.mysql.blog.base.mapper.IRoleResourceMapper;
import org.github.mysql.blog.base.service.IRoleResourceService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class RoleResourceServiceImpl : ServiceImpl<IRoleResourceMapper, RoleResourceEntity>(), IRoleResourceService
