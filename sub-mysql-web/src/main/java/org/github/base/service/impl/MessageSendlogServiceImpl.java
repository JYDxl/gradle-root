package org.github.base.service.impl;

import org.github.base.entity.MessageSendlogEntity;
import org.github.base.mapper.IMessageSendlogMapper;
import org.github.base.service.IMessageSendlogService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-20
 */
@Service
public class MessageSendlogServiceImpl extends ServiceImpl<IMessageSendlogMapper, MessageSendlogEntity> implements IMessageSendlogService {}
