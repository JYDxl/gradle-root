@file:Suppress("RedundantSemicolon")

package org.github.mysql.course.mapper;

import org.github.mysql.course.entity.SectionMbpPo;
import org.github.core.base.IMapper;
import org.github.core.mybatis.MyBatisMapper;

/**
 * 小节 Mapper 接口
 *
 * @author JYD_XL
 */
@MyBatisMapper
interface ISectionMbpMapper : IMapper<SectionMbpPo>
