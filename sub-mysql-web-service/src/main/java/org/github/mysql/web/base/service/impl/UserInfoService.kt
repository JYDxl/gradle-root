@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.UserInfoEntity;
import org.github.mysql.web.base.mapper.IUserInfoMapper;
import org.github.mysql.web.base.service.IUserInfoService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 用户表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class UserInfoService : ServiceImpl<IUserInfoMapper, UserInfoEntity>(), IUserInfoService
