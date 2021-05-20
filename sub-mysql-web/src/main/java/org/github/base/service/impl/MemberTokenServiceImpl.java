package org.github.base.service.impl;

import org.github.base.entity.MemberTokenEntity;
import org.github.base.mapper.IMemberTokenMapper;
import org.github.base.service.IMemberTokenService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-20
 */
@Service
public class MemberTokenServiceImpl extends ServiceImpl<IMemberTokenMapper, MemberTokenEntity> implements IMemberTokenService {}
