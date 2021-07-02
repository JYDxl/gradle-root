@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ClNewsCommentsEntity;
import org.github.mysql.leadnews.base.mapper.IClNewsCommentsMapper;
import org.github.mysql.leadnews.base.service.IClNewsCommentsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 爬得图文评论信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ClNewsCommentsServiceImpl : ServiceImpl<IClNewsCommentsMapper, ClNewsCommentsEntity>(), IClNewsCommentsService
