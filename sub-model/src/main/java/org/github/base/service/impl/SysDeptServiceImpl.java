package org.github.base.service.impl;

import org.github.base.entity.SysDeptEntity;
import org.github.base.mapper.ISysDeptMapper;
import org.github.base.service.ISysDeptService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 部门表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-12-12
 */
@Service
public class SysDeptServiceImpl extends ServiceImpl<ISysDeptMapper, SysDeptEntity> implements ISysDeptService {}
