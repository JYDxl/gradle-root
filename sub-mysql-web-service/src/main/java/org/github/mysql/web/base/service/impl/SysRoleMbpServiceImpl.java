package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.SysRoleMbpEntity;
import org.github.mysql.web.base.mapper.ISysRoleMbpMapper;
import org.github.mysql.web.base.service.ISysRoleMbpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 角色 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-28
 */
@Service
public class SysRoleMbpServiceImpl extends ServiceImpl<ISysRoleMbpMapper, SysRoleMbpEntity> implements ISysRoleMbpService {}
