@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApUserLetterEntity;
import org.github.mysql.leadnews.base.mapper.IApUserLetterMapper;
import org.github.mysql.leadnews.base.service.IApUserLetterService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP用户私信信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApUserLetterServiceImpl : ServiceImpl<IApUserLetterMapper, ApUserLetterEntity>(), IApUserLetterService
