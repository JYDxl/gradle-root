@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service.impl;

import org.github.mysql.sccore.base.entity.SysClientAuthEntity;
import org.github.mysql.sccore.base.mapper.ISysClientAuthMapper;
import org.github.mysql.sccore.base.service.ISysClientAuthService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 客户端授权表，登录授权、API授权、文件服务授权、调度授权 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class SysClientAuthService : ServiceImpl<ISysClientAuthMapper, SysClientAuthEntity>(), ISysClientAuthService
