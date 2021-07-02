@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.AdUserRoleEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 管理员角色信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAdUserRoleMapper : IMapper<AdUserRoleEntity>
