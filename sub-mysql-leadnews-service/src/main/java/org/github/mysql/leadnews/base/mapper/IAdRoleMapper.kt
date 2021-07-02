@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.AdRoleEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 角色信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IAdRoleMapper : IMapper<AdRoleEntity>
