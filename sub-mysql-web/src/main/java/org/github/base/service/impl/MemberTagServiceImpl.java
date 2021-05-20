package org.github.base.service.impl;

import org.github.base.entity.MemberTagEntity;
import org.github.base.mapper.IMemberTagMapper;
import org.github.base.service.IMemberTagService;
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
public class MemberTagServiceImpl extends ServiceImpl<IMemberTagMapper, MemberTagEntity> implements IMemberTagService {}
