@file:Suppress("RedundantSemicolon")

package org.github.mysql.sccore.base.service;

import org.github.mysql.sccore.base.entity.SysClientAuthEntity;
import org.github.base.IService;

/**
 * 客户端授权表，登录授权、API授权、文件服务授权、调度授权 服务类
 *
 * @author JYD_XL
 */
interface ISysClientAuthService : IService<SysClientAuthEntity>
