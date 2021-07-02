@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdSensitiveEntity;
import org.github.mysql.leadnews.base.mapper.IAdSensitiveMapper;
import org.github.mysql.leadnews.base.service.IAdSensitiveService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 敏感词信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdSensitiveServiceImpl : ServiceImpl<IAdSensitiveMapper, AdSensitiveEntity>(), IAdSensitiveService
