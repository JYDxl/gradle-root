@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApUserFanEntity;
import org.github.mysql.leadnews.base.mapper.IApUserFanMapper;
import org.github.mysql.leadnews.base.service.IApUserFanService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP用户粉丝信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApUserFanServiceImpl : ServiceImpl<IApUserFanMapper, ApUserFanEntity>(), IApUserFanService
