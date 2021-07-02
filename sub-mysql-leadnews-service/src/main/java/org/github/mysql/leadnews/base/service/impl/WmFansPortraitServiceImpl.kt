@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.WmFansPortraitEntity;
import org.github.mysql.leadnews.base.mapper.IWmFansPortraitMapper;
import org.github.mysql.leadnews.base.service.IWmFansPortraitService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 自媒体粉丝画像信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class WmFansPortraitServiceImpl : ServiceImpl<IWmFansPortraitMapper, WmFansPortraitEntity>(), IWmFansPortraitService
