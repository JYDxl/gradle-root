@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApUserMessageEntity;
import org.github.mysql.leadnews.base.mapper.IApUserMessageMapper;
import org.github.mysql.leadnews.base.service.IApUserMessageService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP用户消息通知信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApUserMessageServiceImpl : ServiceImpl<IApUserMessageMapper, ApUserMessageEntity>(), IApUserMessageService
