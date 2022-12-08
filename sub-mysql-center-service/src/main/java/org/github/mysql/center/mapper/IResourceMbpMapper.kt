@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.mapper;

import org.github.mysql.center.entity.ResourceMbpPo;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 * 资源 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IResourceMbpMapper : IMapper<ResourceMbpPo>
