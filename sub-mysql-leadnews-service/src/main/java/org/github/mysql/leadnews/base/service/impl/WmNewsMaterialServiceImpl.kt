@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.WmNewsMaterialEntity;
import org.github.mysql.leadnews.base.mapper.IWmNewsMaterialMapper;
import org.github.mysql.leadnews.base.service.IWmNewsMaterialService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 自媒体图文引用素材信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class WmNewsMaterialServiceImpl : ServiceImpl<IWmNewsMaterialMapper, WmNewsMaterialEntity>(), IWmNewsMaterialService
