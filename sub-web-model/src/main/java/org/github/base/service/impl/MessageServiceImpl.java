package org.github.base.service.impl;

import org.github.base.entity.MessageEntity;
import org.github.base.mapper.IMessageMapper;
import org.github.base.service.IMessageService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author JYD_XL
 * @since 2021-05-08
 */
@Service
public class MessageServiceImpl extends ServiceImpl<IMessageMapper, MessageEntity> implements IMessageService {}
