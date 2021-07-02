@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdminQrtzLocksEntity;
import org.github.mysql.leadnews.base.mapper.IAdminQrtzLocksMapper;
import org.github.mysql.leadnews.base.service.IAdminQrtzLocksService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdminQrtzLocksServiceImpl : ServiceImpl<IAdminQrtzLocksMapper, AdminQrtzLocksEntity>(), IAdminQrtzLocksService
