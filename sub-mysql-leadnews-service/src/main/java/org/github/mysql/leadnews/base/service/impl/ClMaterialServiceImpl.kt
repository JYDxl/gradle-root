@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ClMaterialEntity;
import org.github.mysql.leadnews.base.mapper.IClMaterialMapper;
import org.github.mysql.leadnews.base.service.IClMaterialService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 爬得图文素材信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ClMaterialServiceImpl : ServiceImpl<IClMaterialMapper, ClMaterialEntity>(), IClMaterialService
