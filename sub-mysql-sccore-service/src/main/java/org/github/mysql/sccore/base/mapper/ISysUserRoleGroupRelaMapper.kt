@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.mapper;

import org.github.mysql.sccore.base.entity.SysUserRoleGroupRelaEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 用户角色组管理 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISysUserRoleGroupRelaMapper : IMapper<SysUserRoleGroupRelaEntity>
