package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.SysUserEntity;
import org.github.mysql.web.base.mapper.ISysUserMapper;
import org.github.mysql.web.base.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-22
 */
@Service
public class SysUserServiceImpl extends ServiceImpl<ISysUserMapper, SysUserEntity> implements ISysUserService {}
