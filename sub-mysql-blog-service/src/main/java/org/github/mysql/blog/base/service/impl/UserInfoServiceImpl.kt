@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.UserInfoEntity;
import org.github.mysql.blog.base.mapper.IUserInfoMapper;
import org.github.mysql.blog.base.service.IUserInfoService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class UserInfoServiceImpl : ServiceImpl<IUserInfoMapper, UserInfoEntity>(), IUserInfoService
