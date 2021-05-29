@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.SysUserRoleEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 用户与角色对应关系 Mapper 接口
 *
 * @author JYD_XL
 * @since 2021-05-30
 */
@MyBatisMapper
interface ISysUserRoleMapper : IMapper<SysUserRoleEntity>
