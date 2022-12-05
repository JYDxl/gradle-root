@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.base.mapper;

import org.github.mysql.course.base.entity.SectionMbpEntity;
import org.github.base.IMapper;
import org.github.mybatis.MyBatisMapper;

/**
 * 小节 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISectionMbpMapper : IMapper<SectionMbpEntity>
