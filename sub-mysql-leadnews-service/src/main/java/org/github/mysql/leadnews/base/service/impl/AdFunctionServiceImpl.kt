@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.AdFunctionEntity;
import org.github.mysql.leadnews.base.mapper.IAdFunctionMapper;
import org.github.mysql.leadnews.base.service.IAdFunctionService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 页面功能信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class AdFunctionServiceImpl : ServiceImpl<IAdFunctionMapper, AdFunctionEntity>(), IAdFunctionService
