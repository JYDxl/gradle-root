package org.github.base.mapper;

import org.github.base.entity.UsersEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 用户表  Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-07
 */
@MyBatisMapper
public interface IUsersMapper extends IMapper<UsersEntity> {}
