package org.github.base.service.impl;

import org.github.base.entity.SysRoleEntity;
import org.github.base.mapper.ISysRoleMapper;
import org.github.base.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sys_role_table 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-02-25
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<ISysRoleMapper, SysRoleEntity> implements ISysRoleService {}
