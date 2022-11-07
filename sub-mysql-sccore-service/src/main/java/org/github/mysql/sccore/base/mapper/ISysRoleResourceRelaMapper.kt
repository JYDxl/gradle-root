@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.mapper;

import org.github.mysql.sccore.base.entity.SysRoleResourceRelaEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 角色资源管理 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysRoleResourceRelaMapper : IMapper<SysRoleResourceRelaEntity>