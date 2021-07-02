@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.WmMaterialEntity;
import org.github.mysql.leadnews.base.mapper.IWmMaterialMapper;
import org.github.mysql.leadnews.base.service.IWmMaterialService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 自媒体图文素材信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class WmMaterialServiceImpl : ServiceImpl<IWmMaterialMapper, WmMaterialEntity>(), IWmMaterialService
