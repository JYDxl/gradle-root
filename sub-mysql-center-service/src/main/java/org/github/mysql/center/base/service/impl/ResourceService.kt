@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.ResourceEntity;
import org.github.mysql.center.base.mapper.IResourceMapper;
import org.github.mysql.center.base.service.IResourceService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 资源 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ResourceService : ServiceImpl<IResourceMapper, ResourceEntity>(), IResourceService
