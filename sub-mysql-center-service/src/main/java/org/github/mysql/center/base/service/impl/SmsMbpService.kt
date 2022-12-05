@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.SmsMbpEntity;
import org.github.mysql.center.base.mapper.ISmsMbpMapper;
import org.github.mysql.center.base.service.ISmsMbpService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 短信验证码 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SmsMbpService : ServiceImpl<ISmsMbpMapper, SmsMbpEntity>(), ISmsMbpService
