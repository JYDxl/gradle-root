package org.github.base.service.impl;

import org.github.base.entity.MemberProfileLogEntity;
import org.github.base.mapper.IMemberProfileLogMapper;
import org.github.base.service.IMemberProfileLogService;
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
public class MemberProfileLogServiceImpl extends ServiceImpl<IMemberProfileLogMapper, MemberProfileLogEntity> implements IMemberProfileLogService {}
