package org.github.base.service.impl;

import org.github.base.entity.MemberLoginLogEntity;
import org.github.base.mapper.IMemberLoginLogMapper;
import org.github.base.service.IMemberLoginLogService;
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
public class MemberLoginLogServiceImpl extends ServiceImpl<IMemberLoginLogMapper, MemberLoginLogEntity> implements IMemberLoginLogService {}
