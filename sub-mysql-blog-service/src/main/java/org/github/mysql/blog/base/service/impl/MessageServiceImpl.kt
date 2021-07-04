@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.MessageEntity;
import org.github.mysql.blog.base.mapper.IMessageMapper;
import org.github.mysql.blog.base.service.IMessageService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class MessageServiceImpl : ServiceImpl<IMessageMapper, MessageEntity>(), IMessageService
