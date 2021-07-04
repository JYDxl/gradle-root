@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.CommentEntity;
import org.github.mysql.blog.base.mapper.ICommentMapper;
import org.github.mysql.blog.base.service.ICommentService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class CommentServiceImpl : ServiceImpl<ICommentMapper, CommentEntity>(), ICommentService
