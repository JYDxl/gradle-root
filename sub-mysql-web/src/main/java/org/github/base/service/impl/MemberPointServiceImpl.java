package org.github.base.service.impl;

import org.github.base.entity.MemberPointEntity;
import org.github.base.mapper.IMemberPointMapper;
import org.github.base.service.IMemberPointService;
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
public class MemberPointServiceImpl extends ServiceImpl<IMemberPointMapper, MemberPointEntity> implements IMemberPointService {}
