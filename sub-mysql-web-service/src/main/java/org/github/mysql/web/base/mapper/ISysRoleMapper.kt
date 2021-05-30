@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.SysRoleEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 角色 Mapper 接口
 *
 * @author JYD_XL
 * @since 2021-05-30
 */
@MyBatisMapper
interface ISysRoleMapper : IMapper<SysRoleEntity>