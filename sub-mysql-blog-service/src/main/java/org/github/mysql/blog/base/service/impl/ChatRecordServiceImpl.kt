@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.ChatRecordEntity;
import org.github.mysql.blog.base.mapper.IChatRecordMapper;
import org.github.mysql.blog.base.service.IChatRecordService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ChatRecordServiceImpl : ServiceImpl<IChatRecordMapper, ChatRecordEntity>(), IChatRecordService
