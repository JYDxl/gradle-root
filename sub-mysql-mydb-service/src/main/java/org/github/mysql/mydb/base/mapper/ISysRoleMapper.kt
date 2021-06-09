@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.mapper;

import org.github.mysql.mydb.base.entity.SysRoleEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 角色表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysRoleMapper : IMapper<SysRoleEntity>
