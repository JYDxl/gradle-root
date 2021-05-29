package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.SysRoleMenuMbpEntity;
import org.github.mysql.web.base.mapper.ISysRoleMenuMbpMapper;
import org.github.mysql.web.base.service.ISysRoleMenuMbpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色与菜单对应关系 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-29
 */
@Service
public class SysRoleMenuMbpServiceImpl extends ServiceImpl<ISysRoleMenuMbpMapper, SysRoleMenuMbpEntity> implements ISysRoleMenuMbpService {}
