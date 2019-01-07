package org.github.base.service.impl;

import org.github.base.entity.SysUserRoleEntity;
import org.github.base.mapper.SysUserRoleMapper;
import org.github.base.service.ISysUserRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sys_user_role_table 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-01-07
 */
@Service
public class SysUserRoleService extends ServiceImpl<SysUserRoleMapper, SysUserRoleEntity> implements ISysUserRoleService {}
