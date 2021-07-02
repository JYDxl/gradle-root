@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ClNewsMaterialEntity;
import org.github.mysql.leadnews.base.mapper.IClNewsMaterialMapper;
import org.github.mysql.leadnews.base.service.IClNewsMaterialService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 爬得图文引用素材信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ClNewsMaterialServiceImpl : ServiceImpl<IClNewsMaterialMapper, ClNewsMaterialEntity>(), IClNewsMaterialService
