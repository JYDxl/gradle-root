@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.ResourceMbpEntity;
import org.github.mysql.center.base.mapper.IResourceMbpMapper;
import org.github.mysql.center.base.service.IResourceMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 资源 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ResourceMbpService : ServiceImpl<IResourceMbpMapper, ResourceMbpEntity>(), IResourceMbpService
