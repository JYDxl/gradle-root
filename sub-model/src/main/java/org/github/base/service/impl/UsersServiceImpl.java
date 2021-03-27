package org.github.base.service.impl;

import org.github.base.entity.UsersEntity;
import org.github.base.mapper.IUsersMapper;
import org.github.base.service.IUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户表  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-03-27
 */
@Service
public class UsersServiceImpl extends ServiceImpl<IUsersMapper, UsersEntity> implements IUsersService {}
