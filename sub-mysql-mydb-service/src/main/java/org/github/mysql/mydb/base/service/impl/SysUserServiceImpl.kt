@file:Suppress("RedundantSemicolon")

package org.github.mysql.mydb.base.service.impl;

import org.github.mysql.mydb.base.entity.SysUserEntity;
import org.github.mysql.mydb.base.mapper.ISysUserMapper;
import org.github.mysql.mydb.base.service.ISysUserService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysUserServiceImpl : ServiceImpl<ISysUserMapper, SysUserEntity>(), ISysUserService
