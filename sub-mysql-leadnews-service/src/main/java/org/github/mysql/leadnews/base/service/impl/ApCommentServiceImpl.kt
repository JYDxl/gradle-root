@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApCommentEntity;
import org.github.mysql.leadnews.base.mapper.IApCommentMapper;
import org.github.mysql.leadnews.base.service.IApCommentService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP评论信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApCommentServiceImpl : ServiceImpl<IApCommentMapper, ApCommentEntity>(), IApCommentService
