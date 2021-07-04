@file:Suppress("RedundantSemicolon")

package org.github.mysql.blog.base.service.impl;

import org.github.mysql.blog.base.entity.TagEntity;
import org.github.mysql.blog.base.mapper.ITagMapper;
import org.github.mysql.blog.base.service.ITagService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 *  服务实现类
 *
 * @author JYD_XL
 */
@Service
open class TagServiceImpl : ServiceImpl<ITagMapper, TagEntity>(), ITagService
