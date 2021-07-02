@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdLabelEntity;
import org.github.mysql.leadnews.base.mapper.IAdLabelMapper;
import org.github.mysql.leadnews.base.service.IAdLabelService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 标签信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdLabelServiceImpl : ServiceImpl<IAdLabelMapper, AdLabelEntity>(), IAdLabelService
