@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.ChapterEntity;
import org.github.mysql.course.base.mapper.IChapterMapper;
import org.github.mysql.course.base.service.IChapterService;
import org.github.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 大章 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ChapterService : ServiceImpl<IChapterMapper, ChapterEntity>(), IChapterService
