package org.github.base.service.impl;

import org.github.base.entity.SysUserEntity;
import org.github.base.mapper.ISysUserMapper;
import org.github.base.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * sys_user_table 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2019-03-17
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<ISysUserMapper, SysUserEntity> implements ISysUserService {}
