package org.github.base.service.impl;

import org.github.base.entity.SysPostEntity;
import org.github.base.mapper.ISysPostMapper;
import org.github.base.service.ISysPostService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 岗位信息表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-12-12
 */
@Service
public class SysPostServiceImpl extends ServiceImpl<ISysPostMapper, SysPostEntity> implements ISysPostService {}
