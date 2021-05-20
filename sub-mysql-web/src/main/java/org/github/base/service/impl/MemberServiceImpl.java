package org.github.base.service.impl;

import org.github.base.entity.MemberEntity;
import org.github.base.mapper.IMemberMapper;
import org.github.base.service.IMemberService;
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
public class MemberServiceImpl extends ServiceImpl<IMemberMapper, MemberEntity> implements IMemberService {}
