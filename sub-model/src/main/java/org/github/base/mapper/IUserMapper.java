package org.github.base.mapper;

import org.github.base.entity.UserEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-04-21
 */
@MyBatisMapper
public interface IUserMapper extends IMapper<UserEntity> {}