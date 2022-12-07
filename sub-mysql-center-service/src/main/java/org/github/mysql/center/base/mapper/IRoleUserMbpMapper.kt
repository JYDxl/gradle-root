@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.mapper;

import org.github.mysql.center.base.entity.RoleUserMbpEntity;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 * 角色用户关联 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IRoleUserMbpMapper : IMapper<RoleUserMbpEntity>
