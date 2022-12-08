@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.service.impl;

import org.github.mysql.center.entity.RoleMbpPo;
import org.github.mysql.center.mapper.IRoleMbpMapper;
import org.github.mysql.center.service.IRoleMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class RoleMbpService : ServiceImpl<IRoleMbpMapper, RoleMbpPo>(), IRoleMbpService
