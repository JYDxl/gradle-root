package org.github.base.service.impl;

import org.github.base.entity.SysUserOnlineEntity;
import org.github.base.mapper.ISysUserOnlineMapper;
import org.github.base.service.ISysUserOnlineService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 在线用户记录 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-12-12
 */
@Service
public class SysUserOnlineServiceImpl extends ServiceImpl<ISysUserOnlineMapper, SysUserOnlineEntity> implements ISysUserOnlineService {}
