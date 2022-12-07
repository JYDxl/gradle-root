@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.service.impl;

import org.github.mysql.course.base.entity.ChapterMbpEntity;
import org.github.mysql.course.base.mapper.IChapterMbpMapper;
import org.github.mysql.course.base.service.IChapterMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 大章 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ChapterMbpService : ServiceImpl<IChapterMbpMapper, ChapterMbpEntity>(), IChapterMbpService
