@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApUserRealnameEntity;
import org.github.mysql.leadnews.base.mapper.IApUserRealnameMapper;
import org.github.mysql.leadnews.base.service.IApUserRealnameService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP实名认证信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApUserRealnameServiceImpl : ServiceImpl<IApUserRealnameMapper, ApUserRealnameEntity>(), IApUserRealnameService
