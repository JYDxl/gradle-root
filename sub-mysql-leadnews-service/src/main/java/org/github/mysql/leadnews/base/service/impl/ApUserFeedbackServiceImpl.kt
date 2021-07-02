@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApUserFeedbackEntity;
import org.github.mysql.leadnews.base.mapper.IApUserFeedbackMapper;
import org.github.mysql.leadnews.base.service.IApUserFeedbackService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP用户反馈信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApUserFeedbackServiceImpl : ServiceImpl<IApUserFeedbackMapper, ApUserFeedbackEntity>(), IApUserFeedbackService
