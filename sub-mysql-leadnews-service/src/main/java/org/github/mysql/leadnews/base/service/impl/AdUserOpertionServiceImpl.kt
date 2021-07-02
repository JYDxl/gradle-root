@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdUserOpertionEntity;
import org.github.mysql.leadnews.base.mapper.IAdUserOpertionMapper;
import org.github.mysql.leadnews.base.service.IAdUserOpertionService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 管理员操作行为信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdUserOpertionServiceImpl : ServiceImpl<IAdUserOpertionMapper, AdUserOpertionEntity>(), IAdUserOpertionService
