@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.mapper;

import org.github.mysql.web.base.entity.SysRoleEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 角色 Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-29
 */
@MyBatisMapper
interface ISysRoleMapper : IMapper<SysRoleEntity>
