package org.github.base.mapper;

import org.github.base.entity.UserAddressEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * <p>
 * 用户地址表  Mapper 接口
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-16
 */
@MyBatisMapper
public interface IUserAddressMapper extends IMapper<UserAddressEntity> {}
