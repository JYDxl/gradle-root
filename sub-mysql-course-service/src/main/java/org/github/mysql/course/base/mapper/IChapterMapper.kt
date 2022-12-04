@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.mapper;

import org.github.mysql.course.base.entity.ChapterEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 大章 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface IChapterMapper : IMapper<ChapterEntity>
