@file:Suppress("RedundantSemicolon")

package org.github.mysql.center.base.service.impl;

import org.github.mysql.center.base.entity.RoleMbpEntity;
import org.github.mysql.center.base.mapper.IRoleMbpMapper;
import org.github.mysql.center.base.service.IRoleMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 角色 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class RoleMbpService : ServiceImpl<IRoleMbpMapper, RoleMbpEntity>(), IRoleMbpService
