@file:Suppress("RedundantSemicolon")

package org.github.mysql.web.base.service.impl;

import org.github.mysql.web.base.entity.HseHouseImageEntity;
import org.github.mysql.web.base.mapper.IHseHouseImageMapper;
import org.github.mysql.web.base.service.IHseHouseImageService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 房源图片 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class HseHouseImageServiceImpl : ServiceImpl<IHseHouseImageMapper, HseHouseImageEntity>(), IHseHouseImageService
