package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.SysRoleEntity;
import org.github.mysql.web.base.mapper.ISysRoleMapper;
import org.github.mysql.web.base.service.ISysRoleService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-22
 */
@Service
public class SysRoleServiceImpl extends ServiceImpl<ISysRoleMapper, SysRoleEntity> implements ISysRoleService {}