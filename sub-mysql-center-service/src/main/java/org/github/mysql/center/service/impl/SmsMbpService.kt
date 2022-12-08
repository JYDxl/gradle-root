@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.service.impl;

import org.github.mysql.center.entity.SmsMbpPo;
import org.github.mysql.center.mapper.ISmsMbpMapper;
import org.github.mysql.center.service.ISmsMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 短信验证码 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SmsMbpService : ServiceImpl<ISmsMbpMapper, SmsMbpPo>(), ISmsMbpService
