package org.github.base.service.impl;

import org.github.base.entity.MemberProfileEntity;
import org.github.base.mapper.IMemberProfileMapper;
import org.github.base.service.IMemberProfileService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-07
 */
@Service
public class MemberProfileServiceImpl extends ServiceImpl<IMemberProfileMapper, MemberProfileEntity> implements IMemberProfileService {}
