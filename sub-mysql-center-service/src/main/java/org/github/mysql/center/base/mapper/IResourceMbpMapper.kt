@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.mapper;

import org.github.mysql.center.base.entity.ResourceMbpEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 资源 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IResourceMbpMapper : IMapper<ResourceMbpEntity>
