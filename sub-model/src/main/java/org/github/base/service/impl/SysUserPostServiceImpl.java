package org.github.base.service.impl;

import org.github.base.entity.SysUserPostEntity;
import org.github.base.mapper.ISysUserPostMapper;
import org.github.base.service.ISysUserPostService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与岗位关联表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-20
 */
@Service
public class SysUserPostServiceImpl extends ServiceImpl<ISysUserPostMapper, SysUserPostEntity> implements ISysUserPostService {}
