@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdminQrtzJobDetailsEntity;
import org.github.mysql.leadnews.base.mapper.IAdminQrtzJobDetailsMapper;
import org.github.mysql.leadnews.base.service.IAdminQrtzJobDetailsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdminQrtzJobDetailsServiceImpl : ServiceImpl<IAdminQrtzJobDetailsMapper, AdminQrtzJobDetailsEntity>(), IAdminQrtzJobDetailsService
