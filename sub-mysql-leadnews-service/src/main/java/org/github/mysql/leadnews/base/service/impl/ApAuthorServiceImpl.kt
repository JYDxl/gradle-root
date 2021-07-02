@file:Suppress("RedundantSemicolon")

package org.github.mysql.leadnews.base.service.impl;

import org.github.mysql.leadnews.base.entity.ApAuthorEntity;
import org.github.mysql.leadnews.base.mapper.IApAuthorMapper;
import org.github.mysql.leadnews.base.service.IApAuthorService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * APP文章作者信息表 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ApAuthorServiceImpl : ServiceImpl<IApAuthorMapper, ApAuthorEntity>(), IApAuthorService
