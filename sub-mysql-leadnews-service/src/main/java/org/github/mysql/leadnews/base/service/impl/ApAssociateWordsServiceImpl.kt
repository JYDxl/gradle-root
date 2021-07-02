@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApAssociateWordsEntity;
import org.github.mysql.leadnews.base.mapper.IApAssociateWordsMapper;
import org.github.mysql.leadnews.base.service.IApAssociateWordsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 联想词表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApAssociateWordsServiceImpl : ServiceImpl<IApAssociateWordsMapper, ApAssociateWordsEntity>(), IApAssociateWordsService
