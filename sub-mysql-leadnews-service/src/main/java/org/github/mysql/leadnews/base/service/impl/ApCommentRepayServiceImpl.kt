@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApCommentRepayEntity;
import org.github.mysql.leadnews.base.mapper.IApCommentRepayMapper;
import org.github.mysql.leadnews.base.service.IApCommentRepayService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP评论回复信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApCommentRepayServiceImpl : ServiceImpl<IApCommentRepayMapper, ApCommentRepayEntity>(), IApCommentRepayService
