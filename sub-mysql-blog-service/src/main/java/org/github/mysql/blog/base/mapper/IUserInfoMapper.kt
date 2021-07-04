@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.mapper;

import org.github.mysql.blog.base.entity.UserInfoEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 *  Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IUserInfoMapper : IMapper<UserInfoEntity>
