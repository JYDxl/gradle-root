@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.SmsEntity;
import org.github.mysql.center.base.mapper.ISmsMapper;
import org.github.mysql.center.base.service.ISmsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 短信验证码 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SmsService : ServiceImpl<ISmsMapper, SmsEntity>(), ISmsService
