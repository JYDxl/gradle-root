package org.github.base.service.impl;

import org.github.base.entity.TbUserEntity;
import org.github.base.mapper.ITbUserMapper;
import org.github.base.service.ITbUserService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-08
 */
@Service
public class TbUserServiceImpl extends ServiceImpl<ITbUserMapper, TbUserEntity> implements ITbUserService {}
