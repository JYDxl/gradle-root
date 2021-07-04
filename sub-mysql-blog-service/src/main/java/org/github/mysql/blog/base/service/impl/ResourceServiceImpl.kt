@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.ResourceEntity;
import org.github.mysql.blog.base.mapper.IResourceMapper;
import org.github.mysql.blog.base.service.IResourceService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ResourceServiceImpl : ServiceImpl<IResourceMapper, ResourceEntity>(), IResourceService
