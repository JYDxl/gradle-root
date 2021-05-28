package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.SysUserRoleMbpEntity;
import org.github.mysql.web.base.mapper.ISysUserRoleMbpMapper;
import org.github.mysql.web.base.service.ISysUserRoleMbpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 用户与角色对应关系 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-28
 */
@Service
public class SysUserRoleMbpServiceImpl extends ServiceImpl<ISysUserRoleMbpMapper, SysUserRoleMbpEntity> implements ISysUserRoleMbpService {}
