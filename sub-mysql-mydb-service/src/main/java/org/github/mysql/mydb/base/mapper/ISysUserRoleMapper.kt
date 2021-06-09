@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.mapper;

import org.github.mysql.mydb.base.entity.SysUserRoleEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 用户-角色关系表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysUserRoleMapper : IMapper<SysUserRoleEntity>
