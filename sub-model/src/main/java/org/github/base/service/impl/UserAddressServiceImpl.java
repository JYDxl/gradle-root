package org.github.base.service.impl;

import org.github.base.entity.UserAddressEntity;
import org.github.base.mapper.IUserAddressMapper;
import org.github.base.service.IUserAddressService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户地址表  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-16
 */
@Service
public class UserAddressServiceImpl extends ServiceImpl<IUserAddressMapper, UserAddressEntity> implements IUserAddressService {}
