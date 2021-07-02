@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.WmNewsEntity;
import org.github.mysql.leadnews.base.mapper.IWmNewsMapper;
import org.github.mysql.leadnews.base.service.IWmNewsService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 自媒体图文内容信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class WmNewsServiceImpl : ServiceImpl<IWmNewsMapper, WmNewsEntity>(), IWmNewsService
