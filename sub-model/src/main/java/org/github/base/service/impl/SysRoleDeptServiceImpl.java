package org.github.base.service.impl;

import org.github.base.entity.SysRoleDeptEntity;
import org.github.base.mapper.ISysRoleDeptMapper;
import org.github.base.service.ISysRoleDeptService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色和部门关联表 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-11-21
 */
@Service
public class SysRoleDeptServiceImpl extends ServiceImpl<ISysRoleDeptMapper, SysRoleDeptEntity> implements ISysRoleDeptService {}
