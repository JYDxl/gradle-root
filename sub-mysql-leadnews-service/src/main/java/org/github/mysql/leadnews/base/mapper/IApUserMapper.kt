@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.mapper;

import org.github.mysql.leadnews.base.entity.ApUserEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * APP用户信息表 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IApUserMapper : IMapper<ApUserEntity>
