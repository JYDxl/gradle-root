@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ClNewsEntity;
import org.github.mysql.leadnews.base.mapper.IClNewsMapper;
import org.github.mysql.leadnews.base.service.IClNewsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ClNewsServiceImpl : ServiceImpl<IClNewsMapper, ClNewsEntity>(), IClNewsService
