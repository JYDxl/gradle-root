package org.github.base.service.impl;

import org.github.base.entity.MemberCarEntity;
import org.github.base.mapper.IMemberCarMapper;
import org.github.base.service.IMemberCarService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-08
 */
@Service
public class MemberCarServiceImpl extends ServiceImpl<IMemberCarMapper, MemberCarEntity> implements IMemberCarService {}