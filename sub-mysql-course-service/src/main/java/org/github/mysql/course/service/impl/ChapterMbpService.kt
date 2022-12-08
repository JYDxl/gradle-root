@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.service.impl;

import org.github.mysql.course.entity.ChapterMbpPo;
import org.github.mysql.course.mapper.IChapterMbpMapper;
import org.github.mysql.course.service.IChapterMbpService;
import org.github.core.base.ServiceImpl;
import org.springframework.stereotype.Service;

/**
 * 大章 服务实现类
 *
 * @author JYD_XL
 */
@Service
open class ChapterMbpService : ServiceImpl<IChapterMbpMapper, ChapterMbpPo>(), IChapterMbpService
