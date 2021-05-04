package org.github.base.service.impl;

import org.github.base.entity.TbUsersEntity;
import org.github.base.mapper.ITbUsersMapper;
import org.github.base.service.ITbUsersService;
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
public class TbUsersServiceImpl extends ServiceImpl<ITbUsersMapper, TbUsersEntity> implements ITbUsersService {}
