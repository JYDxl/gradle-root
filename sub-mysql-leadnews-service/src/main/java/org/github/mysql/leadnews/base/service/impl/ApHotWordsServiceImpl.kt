@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApHotWordsEntity;
import org.github.mysql.leadnews.base.mapper.IApHotWordsMapper;
import org.github.mysql.leadnews.base.service.IApHotWordsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 搜索热词表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApHotWordsServiceImpl : ServiceImpl<IApHotWordsMapper, ApHotWordsEntity>(), IApHotWordsService
