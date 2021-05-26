package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.SysUserMbpEntity;
import org.github.mysql.web.base.mapper.ISysUserMbpMapper;
import org.github.mysql.web.base.service.ISysUserMbpService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 * 系统用户 服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-26
 */
@Service
public class SysUserMbpServiceImpl extends ServiceImpl<ISysUserMbpMapper, SysUserMbpEntity> implements ISysUserMbpService {}
