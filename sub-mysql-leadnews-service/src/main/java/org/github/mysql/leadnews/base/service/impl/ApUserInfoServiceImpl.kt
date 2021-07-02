@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApUserInfoEntity;
import org.github.mysql.leadnews.base.mapper.IApUserInfoMapper;
import org.github.mysql.leadnews.base.service.IApUserInfoService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP用户信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApUserInfoServiceImpl : ServiceImpl<IApUserInfoMapper, ApUserInfoEntity>(), IApUserInfoService
