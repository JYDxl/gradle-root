@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.mapper;

import org.github.mysql.center.entity.RoleResourceMbpPo;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 * 角色资源关联 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IRoleResourceMbpMapper : IMapper<RoleResourceMbpPo>
