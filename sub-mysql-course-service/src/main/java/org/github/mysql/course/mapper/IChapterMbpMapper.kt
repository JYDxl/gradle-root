@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.mapper;

import org.github.mysql.course.entity.ChapterMbpPo;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 * 大章 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IChapterMbpMapper : IMapper<ChapterMbpPo>
