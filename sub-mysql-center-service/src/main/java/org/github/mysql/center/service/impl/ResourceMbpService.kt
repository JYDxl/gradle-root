@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.service.impl;

import org.github.mysql.center.entity.ResourceMbpPo;
import org.github.mysql.center.mapper.IResourceMbpMapper;
import org.github.mysql.center.service.IResourceMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 资源 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ResourceMbpService : ServiceImpl<IResourceMbpMapper, ResourceMbpPo>(), IResourceMbpService
