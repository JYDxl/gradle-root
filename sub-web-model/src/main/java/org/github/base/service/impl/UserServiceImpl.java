package org.github.base.service.impl;

import org.github.base.entity.UserEntity;
import org.github.base.mapper.IUserMapper;
import org.github.base.service.IUserService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-04
 */
@Service
public class UserServiceImpl extends ServiceImpl<IUserMapper, UserEntity> implements IUserService {}
