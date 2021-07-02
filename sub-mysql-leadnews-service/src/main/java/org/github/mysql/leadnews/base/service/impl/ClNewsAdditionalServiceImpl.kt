@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ClNewsAdditionalEntity;
import org.github.mysql.leadnews.base.mapper.IClNewsAdditionalMapper;
import org.github.mysql.leadnews.base.service.IClNewsAdditionalService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 爬得图文附属信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ClNewsAdditionalServiceImpl : ServiceImpl<IClNewsAdditionalMapper, ClNewsAdditionalEntity>(), IClNewsAdditionalService
